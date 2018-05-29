package com.david.edshirorolesystem.web.controller;

import com.david.edshirorolesystem.po.Userlogin;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 登录的controller
 *
 * @author david
 */

@Controller
public class LoginController {
    /**
     * get请求方式，转发到登录的login.jsp
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginUi() {
        System.err.println("login");
        return "../../login";
    }

    /**
     * Post 方式，登录的功能请求
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Userlogin userLogin) {
        if (StringUtils.isEmpty(userLogin.getUsername()) || StringUtils.isEmpty(userLogin.getPassword())) {
            return loginUi();
        }
        // shiro实现登录
        UsernamePasswordToken token = new UsernamePasswordToken(userLogin.getUsername(), userLogin.getPassword());
        org.apache.shiro.subject.Subject subject = SecurityUtils.getSubject();
        // 如果获取不到用户名，就是登录失败，但登录失败的话，会直接抛出异常
        try {
            subject.login(token);
            if (subject.hasRole("admin")) {
                // 则是管理员
                return "redirect:/admin/showStudent";
            } else if (subject.hasRole("teacher")) {
                return "redirect:/teacher/showCourse";
            } else if (subject.hasRole("student")) {
                return "redirect:/student/showCourse";
            }
        } catch (Exception e) {
            return loginUi();
        }
        return loginUi();

    }

}
