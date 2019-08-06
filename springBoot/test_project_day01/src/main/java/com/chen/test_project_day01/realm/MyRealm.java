package com.chen.test_project_day01.realm;

import com.chen.test_project_day01.entity.User;
import com.chen.test_project_day01.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.AccountException;

@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private IUserService iUserService;
    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        User user = iUserService.findByUname(username);
        if(user==null){
            throw new UnknownAccountException("该用户不存在！");
        }
        SimpleAuthenticationInfo sai = new SimpleAuthenticationInfo(user, user.getUpasswd(), this.getName());
        return sai;
    }
}
