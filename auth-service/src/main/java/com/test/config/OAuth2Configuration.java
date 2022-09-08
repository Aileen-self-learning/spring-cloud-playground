package com.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

import javax.annotation.Resource;

@EnableAuthorizationServer //开启授权服务器
@Configuration
public class OAuth2Configuration extends AuthorizationServerConfigurerAdapter {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private UserDetailsService service;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //配置客户端详情服务（ClientDetailsService）
    //客户端详情信息在这里进行初始化，你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
    //这里使用内存方式存储
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory() //使用内存中的secret，也可用jdbc从数据库读取
                .withClient("web")
                .secret(encoder.encode("654321")) //只与客户端分享的secret
                .autoApprove(false)  //设置是否自动审批
                .scopes("book", "user", "borrow") //设置授权范围
                .redirectUris("http://localhost:8201/login") //设置重定向地址
                .authorizedGrantTypes("client_credentials", "password", "implicit", "authorization_code", "refresh_token"); //设置授权模式
    }

    //配置令牌端点(Token Endpoint)的安全约束
    //这里配置了checkTokenAccess，这两个配置的作用是令牌端点(Token Endpoint)的安全约束
    //checkTokenAccess是用来配置令牌端点(Token Endpoint)的权限访问
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                .passwordEncoder(encoder) //设置密码加密方式
                .allowFormAuthenticationForClients()//允许表单验证,post请求时会携带表单信息
                .checkTokenAccess("permitAll()"); //允许所有Token查询请求
    }

    //由于SpringSecurity底层改动，需要配置AuthenticationManager，才能使用password模式
    @Override
     public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
         endpoints
                 .userDetailsService(service) //设置用户信息服务
                 .authenticationManager(authenticationManager);
     }
}
