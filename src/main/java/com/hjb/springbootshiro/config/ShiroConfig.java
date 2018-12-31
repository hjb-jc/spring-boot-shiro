package com.hjb.springbootshiro.config;

import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //创建ShiroFilterFactoryBean
    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactory(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        /*
         * shiro内置过滤器，可以实现权限相关的拦截器
         *   常用的过滤器：
         *       anon: 无需认证，直接访问
         *       authc: 必须认证才可以访问
         *       user: 如果使用rememberMe的功能可以直接访问
         *       perme :该资源必须得到资源权限才可以访问
         *       role: 该资源必须要得到劫色权限才可以访问
         * */
        Map<String, String> fillterMap = new LinkedHashMap<String, String>();
       /* fillterMap.put("/add","authc");
        fillterMap.put("/update","authc");*/

        //需要放行的页面
        fillterMap.put("/a", "anon");

        fillterMap.put("/toTogin", "anon");

        //统一进行拦截
        fillterMap.put("/*", "authc");

        //拦截后指定让它跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/login");

        //setFilterChainDefinitionMap对页面进行管理
        shiroFilterFactoryBean.setFilterChainDefinitionMap(fillterMap);

        return shiroFilterFactoryBean;
    }

    //创建DefautWebSecurityManager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier(value = "userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    //创建Realm

    @Bean(name = "userRealm")
    public UserRealm getRealm() {
        return new UserRealm();
    }
}
