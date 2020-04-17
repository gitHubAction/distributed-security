//package com.seven.distributed.gateway.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
///**
// * @Author: zhangsh
// * @Date: 2020/4/17 15:06
// * @Version 1.0
// * Description  将各个微服务的资源认证配置放到zuul网关层
// */
//@Configuration
//@EnableResourceServer
//public class UAAServerConfig extends ResourceServerConfigurerAdapter {
//
//    @Autowired
//    private TokenStore tokenStore;
//
//    /**
//     * 配置资源
//     * @param resources
//     * @throws Exception
//     */
//    @Override
//    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
//        resources.tokenStore(tokenStore).resourceId("res1").stateless(true);
//    }
//
//    /**
//     * 配置拦截
//     * @param http
//     * @throws Exception
//     */
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        //对访问认证服务器的资源不进行拦截
//        http.authorizeRequests().antMatchers("/uaa/**").permitAll();
//    }
//}
