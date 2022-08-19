package com.controller;

import com.entity.Goods;
import com.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MerchantsController {
    @Autowired
    private GoodsService goodsService;
    /*@Autowired
    private DataSourceTransactionManager transactionManager;*/
    //反馈
    @RequestMapping("/MerchantFeedback")                 //value值要和超链接中的url保持一致(href中的值)
    public String MerchantLogin() {
        return "MidPages/Feedback";
    }
    @RequestMapping("/Merchant/ModifyGoods")
    public String ModifyGoods(String id,String name, String price,String surplus,HttpSession session) {
        if(name==null||price==null||surplus==null){return "MerchantPages/MerchantPage";}//如果有一个为空，则不执行修改
        goodsService.updateGoods(id,name,price,surplus);
        /*DefaultTransactionDefinition def = new DefaultTransactionDefinition();//手动提交事物
        TransactionStatus status = transactionManager.getTransaction(def);
        transactionManager.commit(status);*/
        System.out.println("entry ModifyGoods");
        System.out.println(id);System.out.println(name);System.out.println(price);System.out.println(surplus);
        //下面代码重新从数据库获得这个商家的商品并写入session中
        String merchantName=(String)session.getAttribute("merchantName");   //从session中获得登入成功的商家的名字
        System.out.println("ModifyGoods获得登入的商家名字："+merchantName);
        List<Goods> mGoodsList= goodsService.Msearch(merchantName);         //获得数据
        System.out.println("获得商家的商品："+mGoodsList.toString());
        if(session.getAttribute("mGoodsList")!=null){session.removeAttribute("mGoodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("mGoodsList",mGoodsList);              //写入session
        return "MerchantPages/MerchantPage";//返回这个页面并没有执行重新从数据库查询数据，所以刷新页面没有看到数据改变，需要重新登陆才行
    }
    @RequestMapping("/Merchant/DeleteGoods")
    public String DeleteGoods(String id,HttpSession session) {
        goodsService.deleteGoods(id);
        //下面代码重新从数据库获得这个商家的商品并写入session中
        String merchantName=(String)session.getAttribute("merchantName");   //从session中获得登入成功的商家的名字
        System.out.println("DeleteGoods获得登入的商家名字："+merchantName);
        List<Goods> mGoodsList= goodsService.Msearch(merchantName);         //获得数据
        System.out.println("获得商家的商品："+mGoodsList.toString());
        if(session.getAttribute("mGoodsList")!=null){session.removeAttribute("mGoodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("mGoodsList",mGoodsList);              //写入session
        return "MerchantPages/MerchantPage";//返回这个页面并没有执行重新从数据库查询数据，所以刷新页面没有看到数据改变，需要重新登陆才行
    }
    @RequestMapping("/Merchant/AddGoods")
    public String AddGoods(String name, String price,String surplus,HttpSession session) {
        if(name==null||price==null||surplus==null){return "MerchantPages/MerchantPage";}//如果有一个为空，则不执行修改
        int id=(int)session.getAttribute("endId")+1;            //添加的商品的id等于已有的最大的id值+1
        session.setAttribute("endId",id);
        String merchantName=(String)session.getAttribute("merchantName");   //从session中获得登入成功的商家的名字
        goodsService.addGoods(id,name, price, surplus,merchantName);
        //下面代码重新从数据库获得这个商家的商品并写入session中
        System.out.println("AddGoods获得登入的商家名字："+merchantName);
        List<Goods> mGoodsList= goodsService.Msearch(merchantName);         //获得数据
        System.out.println("获得商家的商品："+mGoodsList.toString());
        if(session.getAttribute("mGoodsList")!=null){session.removeAttribute("mGoodsList");}  //如果键已经存在就删除键，因为setAttribute不会改变已经存在的键的值
        session.setAttribute("mGoodsList",mGoodsList);              //写入session
        return "MerchantPages/MerchantPage";//返回这个页面并没有执行重新从数据库查询数据，所以刷新页面没有看到数据改变，需要重新登陆才行
    }
}
