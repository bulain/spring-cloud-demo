package com.bulain.oauth;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;
import org.springframework.util.Assert;

/**
 * Implementation of authorization code services that stores the codes and authentication in redis.
 * 
 * @author bulain
 *
 */
public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    private static final String AUTH_CODE = "auth_code:";

    private final RedisConnectionFactory connectionFactory;

    private RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();
    private String prefix = "";

    public RedisAuthorizationCodeServices(RedisConnectionFactory connectionFactory) {
        Assert.notNull(connectionFactory, "RedisConnectionFactory required");
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        byte[] serializeKey = serializeKey(AUTH_CODE + code);
        byte[] bytes = serialize(authentication);

        RedisConnection conn = getConnection();
        try {
            conn.set(serializeKey, bytes);
        } finally {
            conn.close();
        }
    }

    public OAuth2Authentication remove(String code) {
        byte[] serializeKey = serializeKey(AUTH_CODE + code);
        byte[] bytes = null;

        RedisConnection conn = getConnection();
        try {
            bytes = conn.get(serializeKey);
            conn.del(serializeKey);
        } finally {
            conn.close();
        }

        OAuth2Authentication authentication = null;
        if (bytes != null) {
            authentication = deserializeAuthentication(bytes);
        }

        return authentication;
    }
    
    private byte[] serialize(String string) {
        return serializationStrategy.serialize(string);
    }
    
    private byte[] serialize(Object object) {
        return serializationStrategy.serialize(object);
    }

    private OAuth2Authentication deserializeAuthentication(byte[] bytes) {
        return serializationStrategy.deserialize(bytes, OAuth2Authentication.class);
    }

    private byte[] serializeKey(String object) {
        return serialize(prefix + object);
    }

    private RedisConnection getConnection() {
        return connectionFactory.getConnection();
    }

    public void setSerializationStrategy(RedisTokenStoreSerializationStrategy serializationStrategy) {
        this.serializationStrategy = serializationStrategy;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
