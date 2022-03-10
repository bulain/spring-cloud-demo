package com.bulain.main;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.oauth2.provider.endpoint.FrameworkEndpoint;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FrameworkEndpoint
public class RevokeTokenEndpoint {

    @Autowired
    @Qualifier("consumerTokenServices")
    private ConsumerTokenServices consumerTokenServices;

    @RequestMapping(value = "/oauth/token", method = RequestMethod.DELETE)
    @ResponseBody
    public void revokeToken(@RequestParam Map<String, String> parameters) {
        String accessToken = parameters.get("access_token");
        if (StringUtils.isNotBlank(accessToken)) {
            consumerTokenServices.revokeToken(accessToken);
        }
    }

}
