package com.controller;

import com.entity.Goods;
import com.entity.Merchants;
import com.service.GoodsService;
import com.service.MerchantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

//主页的controller
@Controller
public class HomeController {
    @Autowired
    private MerchantsService merchantsService;
    @Autowired
    private GoodsService goodsService;
    //打开主页
    @RequestMapping("/")
    public String HomePage(HttpSession session) {
        List<Goods> goodsList= goodsService.search();
        if(session.getAttribute("goodsList")!=null){session.removeAttribute("goodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("goodsList",goodsList);
        if(session.getAttribute("endId")==null){session.setAttribute("endId",goodsList.get(goodsList.size()-1).getId());}//将最后的id写入会话，在添加商品时使用
        System.out.println("最后的id："+(int)session.getAttribute("endId"));
        System.out.println(goodsList.toString());
        return "HomePages/HomePage";        //返回的值加上视图解析器中配置的前后缀就是要访问的页面
    }
    //用户登入输入账号密码页面
    @RequestMapping("/HomePages/UserLogin")                 //value值要和超链接中的url保持一致(href中的值)
    public String UserLogin() {
        return "HomePages/UserLogin";
    }
    //商家登入输入账号密码页面
    @RequestMapping("/HomePages/MerchantLogin")
    public String MerchantLogin() {
        return "HomePages/MerchantLogin";
    }
    //判断商家是否登入成功的页面
    @RequestMapping("/MidPages/LoginSuccess")
    public String MLogin(String name,String password,HttpSession session) { //html页面用户输入的数据会传到参数上
        Merchants m=merchantsService.login(name,password); //controller调用service层的方法，service层调用dao层的方法，通过调用将数据传递给dao层，这样映射文件就可以使用数据做数据库相关操作
        // 判断用户是否登录成功
        if(session.getAttribute("message")!=null){session.removeAttribute("message");}
        if (m != null) {
            session.setAttribute("merchantName",name);
            session.setAttribute("message", "登入成功！");
        } else {
            // 将登录错误信息写入会话
           session.setAttribute("message", "用户名或密码错误！");    //将数据写入到会话中，会话是一个map容器，setAttribute方法添加数据。第一个引号内的是键
        }
        return "MidPages/LoginSuccess";
    }
    //登入成功后跳转到商家中心
    @RequestMapping("/MerchantPages/MerchantPage")
    public String isLogin(HttpSession session) {
        String merchantName=(String)session.getAttribute("merchantName");   //从session中获得登入成功的商家的名字
        System.out.println("获得登入的商家名字："+merchantName);
        List<Goods> mGoodsList= goodsService.Msearch(merchantName);
        System.out.println("获得商家的商品："+mGoodsList.toString());
        if(session.getAttribute("mGoodsList")!=null){session.removeAttribute("mGoodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("mGoodsList",mGoodsList);
        return "MerchantPages/MerchantPage";
    }
    @RequestMapping("/HomePages/merchantNameSort")
    public String merchantNameSort(HttpSession session) {
        List<Goods> goodsList= goodsService.merchantNameSort();
        if(session.getAttribute("goodsList")!=null){session.removeAttribute("goodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("goodsList",goodsList);
        System.out.println(goodsList.toString());
        return "HomePages/HomePage";
    }
    @RequestMapping("/HomePages/goodsNameSort")
    public String goodsNameSort(HttpSession session) {
        List<Goods> goodsList= goodsService.goodsNameSort();
        if(session.getAttribute("goodsList")!=null){session.removeAttribute("goodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("goodsList",goodsList);
        System.out.println(goodsList.toString());
        return "HomePages/HomePage";
    }
    @RequestMapping("/HomePages/VisitsSort")
    public String VisitsSort(HttpSession session) {
        List<Goods> goodsList= goodsService.VisitsSort();
        if(session.getAttribute("goodsList")!=null){session.removeAttribute("goodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("goodsList",goodsList);
        System.out.println(goodsList.toString());
        return "HomePages/HomePage";
    }

}