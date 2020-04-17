package com.seven.distributed.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 11:08
 * @Version 1.0
 * Description
 */
@Configuration
public class TokenConfig {


    @Bean
    public TokenStore tokenStore(){

        return new JwtTokenStore(jwttokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwttokenEnhancer() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("seven");
        return jwtAccessTokenConverter;
    }
}
