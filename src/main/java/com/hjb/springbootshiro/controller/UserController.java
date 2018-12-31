package com.hjb.springbootshiro.controller;

import com.hjb.springbootshiro.entity.News;
import com.hjb.springbootshiro.sevice.imp.NewsServletImp;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private NewsServletImp newsServletImp;
    @RequestMapping("/a")
    public String a(Model model){
        List<News> news = newsServletImp.listAllNews();
        model.addAttribute("news",news);
        return "index";
    }

    @RequestMapping("/add")
    public String add(){
        return "/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "/update";
    }

    @RequestMapping("/login")
    public String login(){
        return "/login";
    }

    @RequestMapping("/toTogin")
    public String toLogin(String userName, String pwd,Model model){
        System.out.println(">>>>>>"+userName);
        //获取Shior编写认证操作
        Subject subject = SecurityUtils.getSubject();
        //封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,pwd);

        //执行登录方法
        try{
            subject.login(token);
            return "redirect:/a";
        }catch (UnknownAccountException e){
            model.addAttribute("msg","用户不存在");
            return "login";
        }catch (IncorrectCredentialsException e){
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }
}
