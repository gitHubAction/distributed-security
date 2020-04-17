package com.seven.distributed.gateway.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 15:04
 * @Version 1.0
 * Description  配置资源服务
 */
//导入配置
@Configuration
@EnableResourceServer
@Import({
        UAAServerConfig.class
        ,OrderServerConfig.class
})
public class ResourceServerConfig {

}
