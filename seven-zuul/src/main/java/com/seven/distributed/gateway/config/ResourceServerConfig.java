package com.seven.distributed.gateway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 15:04
 * @Version 1.0
 * Description  配置资源服务
 */
//导入配置
@Configuration
@EnableResourceServer
//@Import({
//        UAAServerConfig.class
//        ,OrderServerConfig.class
//})
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources
                //设置我这个resource的id, 这个在auth中配置, 这里必须照抄
                .resourceId("res1")
                .tokenStore(tokenStore)

                //这个貌似是配置要不要把token信息记录在session中
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //针对auth的访问无条件放行
                .antMatchers("/uaa/**").permitAll()
                //访问resource,需要令牌中含有scope:scope1
                .antMatchers("/order/**").hasAnyAuthority("r1");
//                .access("#oauth2.hasScope('scope1')");
    }
}
