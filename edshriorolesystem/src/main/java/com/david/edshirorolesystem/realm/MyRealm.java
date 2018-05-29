package com.david.edshirorolesystem.realm;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import com.david.edshirorolesystem.po.Userlogin;
import com.david.edshirorolesystem.service.RoleService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.david.edshirorolesystem.po.Role;
import com.david.edshirorolesystem.service.UserLoginService;

/**
 * @author ：david
 * @新浪微博 ：https://weibo.com/mcxiaobing
 * @github: https://github.com/QQ986945193
 */
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private RoleService roleService;

    /**
     * 在这个方法中，进行登录的时候，身份验证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //用户名
        String username = (String) token.getPrincipal();
        //密码
        String password = new String((char[]) token.getCredentials());
        Userlogin userLogin = null;
        try {
            userLogin = userLoginService.findByName(username);
            if (userLogin == null) {
                // 则说明用户名不存在
                throw new UnknownAccountException();

            } else if (!password.equals(userLogin.getPassword())) {
                //如果密码不一致，则说明密码错误，这里没有进行加密，直接使用的明文匹配
                throw new IncorrectCredentialsException();
            }
            //身份验证通过，返回一个身份信息
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
            return authenticationInfo;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 在这个方法中，进行权限的验证.我们可以在这个方法获取数据库中的角色和权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) getAvailablePrincipal(principalCollection);
        Role role = null;
        try {
            Userlogin userLogin = userLoginService.findByName(username);
            //获取角色对象
            role = roleService.findById(userLogin.getRole());
            // 通过用户名从数据库中获取权限/角色信息
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            Set<String> roles = new HashSet<>();
            if (role != null) {
                roles.add(role.getRolename());
            }
            info.setRoles(roles);
            return info;
        } catch (Exception e) {
            return null;
        }

    }

}
