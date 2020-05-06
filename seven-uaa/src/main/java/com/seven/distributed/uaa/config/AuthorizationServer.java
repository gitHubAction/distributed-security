package com.seven.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.InMemoryClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private ClientDetailsService clientDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;

    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;


    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .tokenKeyAccess("permitAll()")
                .checkTokenAccess("permitAll()")
                //允许表单提交
                .allowFormAuthenticationForClients();
    }


    /**
     * 配置授权客户端信息
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.withClientDetails(clientDetailsService);

        clients
                //采用内存模式来存储客户端信息
                .inMemory()
                .withClient("seven")
                .secret(new BCryptPasswordEncoder().encode("123456"))
                .resourceIds("res1")
                //四种授权类型  授权码模式、账户密码模式、客户端模式、简单模式
                .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")
                .scopes("all")
                .autoApprove(false)
                .redirectUris("http://www.baidu.com");
    }

    /**
     * 配置授权端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.pathMapping("/oauth/authorize","/seven/authorize");
//        endpoints.pathMapping("/oauth/token","/seven/token");
        //配置认证管理器
        endpoints.authenticationManager(authenticationManager).allowedTokenEndpointRequestMethods(HttpMethod.POST);
        //授权码服务
        endpoints.authorizationCodeServices(authorizationCodeServices);
        //token令牌服务
        endpoints.tokenServices(tokenServices());



    }



    /**
     * 客户端信息加载方式
     * @param dataSource
     * @return
     */
    @Bean
    public ClientDetailsService jdbcClientDetails(DataSource dataSource) {
//        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
//        clientDetailsService.setPasswordEncoder(passwordEncoder());
        InMemoryClientDetailsService clientDetailsService = new InMemoryClientDetailsService();
        return clientDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthorizationCodeServices authorizationCodeServices(){
        return new InMemoryAuthorizationCodeServices();
    }


    @Bean
    public AuthorizationServerTokenServices tokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        //设置客户端明细服务
        tokenServices.setClientDetailsService(clientDetailsService);
        tokenServices.setSupportRefreshToken(true);
        //token令牌存储策略
        tokenServices.setTokenStore(tokenStore);
        //token增强
        TokenEnhancerChain tokenEnhancer = new TokenEnhancerChain();
        tokenEnhancer.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        tokenServices.setTokenEnhancer(tokenEnhancer);

        tokenServices.setAccessTokenValiditySeconds(7200);
        tokenServices.setRefreshTokenValiditySeconds(259200);
        return tokenServices;
    }
}
