package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//主页的controller
@Controller
public class HomeController {
    //打开主页
    @RequestMapping("/")
    public String HomePage() {
        return "HomePages/HomePage";
    }   //返回的值加上视图解析器中配置的前后缀就是要访问的页面
    //用户登入
    @RequestMapping("/HomePages/UserLogin")                 //value值要和超链接中的url保持一致(href中的值)
    public String UserLogin() {
        return "HomePages/UserLogin";
    }
    //商家登入
    @RequestMapping("/HomePages/MerchantLogin")
    public String MerchantLogin() {
        return "HomePages/MerchantLogin";
    }





}