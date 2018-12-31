package com.hjb.springbootshiro.config;

import org.apache.catalina.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

//自定义Realm
public class UserRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权逻辑。。。。。");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg) throws AuthenticationException {
        System.out.println("执行认证逻辑........");

        String userName = "admin";
        String pwd = "123";

        UsernamePasswordToken token = (UsernamePasswordToken)arg;
        if(!token.getUsername().equals(userName)){
            //用户名不存在
            return null;//Shiro底层 UnknownAccountException
        }

        return new SimpleAuthenticationInfo("",pwd,"");
    }
}
