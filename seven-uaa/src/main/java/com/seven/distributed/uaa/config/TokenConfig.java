package com.seven.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @Author: zhangsh
 * @Date: 2020/4/16 11:52
 * @Version 1.0
 * Description  token令牌相关配置
 */
@Configuration
public class TokenConfig {


    @Bean
    public TokenStore tokenStore(){
        //采用jwtToken验证方式
        return new JwtTokenStore(jwtTokenEnhancer());
    }

    @Bean
    public JwtAccessTokenConverter jwtTokenEnhancer() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setSigningKey("seven");//验签sign的key
        return jwtAccessTokenConverter;
    }
}
