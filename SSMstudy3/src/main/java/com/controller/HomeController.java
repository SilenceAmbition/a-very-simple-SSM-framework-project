package com.controller;

import com.entity.Merchants;
import com.service.MerchantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

//主页的controller
@Controller
public class HomeController {

    @Autowired
    private MerchantsService merchantsService;
    //打开主页
    @RequestMapping("/")
    public String HomePage() {
        return "HomePages/HomePage";
    }   //返回的值加上视图解析器中配置的前后缀就是要访问的页面
    //用户登入页面
    @RequestMapping("/HomePages/UserLogin")                 //value值要和超链接中的url保持一致(href中的值)
    public String UserLogin() {
        return "HomePages/UserLogin";
    }
    //商家登入页面
    @RequestMapping("/HomePages/MerchantLogin")                 //value值要和超链接中的url保持一致(href中的值)
    public String MerchantLogin() {
        return "HomePages/MerchantLogin";
    }
    //商家登入
    @RequestMapping("/MerchantPages/MerchantPage")
    public String MLogin(String name,String password,HttpSession session) {
        Merchants m=merchantsService.login(name,password);          //controller调用service层的方法，service层调用dao层的方法，间接调用降低耦合度
        // 判断用户是否登录成功
        if (m != null) {
            session.setAttribute("message", "登入成功！");
            return "MerchantPages/MerchantPage";
        } else {
            // 将登录错误信息写入会话
           session.setAttribute("message", "用户名或密码错误！");    //将数据写入到会话中，会话是一个map容器，setAttribute方法添加数据。引号内的是键
            // 跳转到前台登录页面

            return "HomePages/MerchantLogin"; // 逻辑视图名
        }

    }








}