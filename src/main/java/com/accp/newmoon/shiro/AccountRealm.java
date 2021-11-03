package com.accp.newmoon.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.accp.newmoon.entity.User;
import com.accp.newmoon.service.UserService;
import com.accp.newmoon.util.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Slf4j
@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserService userService;
    //为了让realm支持jwt的凭证校验
    @Override
    public boolean supports(AuthenticationToken token){
        return token instanceof JwtToken;
    }

    //获取用户的权限返回给shiro
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
    //进行身份验证的时候获取token，进行密码校验逻辑
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;
        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(Long.valueOf(userId));

        if(user == null){
            throw new UnknownAccountException("叼毛，你的账户不存在");
        }

        if(user.getStatus().equals("0")){
            throw new LockedAccountException("叼毛，你的账户已被封掉了");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);

        System.out.print("--------------------");
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }

////    @Override
////    public boolean supports(AuthenticationToken token) {
////        return token instanceof JwtToken;
////    }
//    //获取用户的权限返回给shiro
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return null;
//    }
//    //进行身份验证的时候获取token，进行密码校验逻辑
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
////        JwtToken jwt = (JwtToken) token;
////        log.info("jwt----------------->{}", jwt);
////        String userId = jwtUtils.getClaimByToken((String) jwt.getPrincipal()).getSubject();
////        User user = userService.getById(Long.parseLong(userId));
////        if(user == null) {
////            throw new UnknownAccountException("账户不存在！");
////        }
////        if(user.getStatus() == -1) {
////            throw new LockedAccountException("账户已被锁定！");
////        }
////        AccountProfile profile = new AccountProfile();
////        BeanUtil.copyProperties(user, profile);
////        log.info("profile----------------->{}", profile.toString());
////        new SimpleAuthenticationInfo(profile, jwt.getCredentials(), getName())
//        return null;
//    }
}

