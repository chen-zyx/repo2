package com.chen.test_project_day01.config;

import com.chen.test_project_day01.realm.MyRealm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class ShiroConfig {
    @Autowired
    private MyRealm myRealm;

    /**
     * 配置shirofactorybean对象
     */
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(this.getSecurityManager());
        //配置能够访问的路径
        bean.setLoginUrl("/tologin");
        //配置没有权限的路径
        bean.setUnauthorizedUrl("/topermit");
        Map<String, String> filterChainDefinitionMap = bean.getFilterChainDefinitionMap();
        //设置匿名请求
        filterChainDefinitionMap.put("/tologin","anon");
        filterChainDefinitionMap.put("/login","anon");
        filterChainDefinitionMap.put("/templates/**","anon");

        //所有请求都需要过滤
        filterChainDefinitionMap.put("/**", "authc");

        return bean;
    }

    /**
     * 创建securityMananger对象
     */
    @Bean
    public SecurityManager getSecurityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myRealm);
        return securityManager;
    }

}
