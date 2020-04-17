package com.seven.distributed.order.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: zhangsh
 * @Date: 2020/4/17 15:23
 * @Version 1.0
 * Description  添加过滤器获取从网关下发的token信息
 */
@Component
public class MyTokenAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String jwtToken = request.getHeader("json-token");
        if(jwtToken != null){
            //解析token，组装用户信息并填充UsernamePasswordAuthenticationToken
            JSONObject userJson = JSON.parseObject(jwtToken);
            Object principal = userJson.get("principal");
            JSONArray authories = userJson.getJSONArray("authories");
            String [] authorities = authories.toArray( new String[authories.size()]);
            //封装为usernamePasswordToken
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(principal,null,
                    AuthorityUtils.createAuthorityList(authorities));

            token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            //设置到SpringSecurity上下文
            SecurityContextHolder.getContext().setAuthentication(token);

        }
        filterChain.doFilter(request,response);
    }
}
