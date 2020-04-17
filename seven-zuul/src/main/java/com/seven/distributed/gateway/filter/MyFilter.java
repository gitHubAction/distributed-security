package com.seven.distributed.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 14:39
 * @Version 1.0
 * Description
 */
public class MyFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        //从springSecurity上下文中获取相关信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof OAuth2Authentication)){
            return null;
        }
        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        //获取用户信息
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        Object principal = userAuthentication.getPrincipal();
        /**
         * 组装权限信息，转为内部json-token放到header中下发给微服务
         */
        List<String> authories = new ArrayList<>();
        userAuthentication.getAuthorities().stream().forEach(s->authories.add(((GrantedAuthority) s).getAuthority()));


        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();

        Map<String, String> requestParameters = oAuth2Request.getRequestParameters();

        Map<String, Object> jwtToken = new HashMap<>(requestParameters);
        jwtToken.put("principal",principal);
        jwtToken.put("authories",authories);
        String token = JSON.toJSONString(jwtToken);
        //可以对token进行编码

        //放入zull请求头中
        RequestContext.getCurrentContext().addZuulRequestHeader("json-token", token);
        return null;
    }
}
