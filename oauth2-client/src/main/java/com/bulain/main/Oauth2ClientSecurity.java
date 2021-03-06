package com.bulain.main;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
@EnableOAuth2Sso
public class Oauth2ClientSecurity extends WebSecurityConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
        // 所有请求都得经过认证和授权
        .authorizeRequests().anyRequest().authenticated()
        // 无需认证
        //.and().authorizeRequests().antMatchers("/anon").permitAll()
        // 这里之所以要禁用csrf，是为了方便。
        // 否则，退出链接必须要发送一个post请求，请求还得带csrf token
        // 那样我还得写一个界面，发送post请求
        .and().csrf().disable()
        // 退出的URL是/logout
        .logout().logoutUrl("/logout").permitAll()
        // 退出成功后，跳转到/路径。
        .logoutSuccessUrl("/anon").permitAll();
    }
}
