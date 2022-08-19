package com.mapper;

public interface GoodsMapper {
    //刷新列表
    int rush();
    //增加商品
    int addGoods();
    //增加商家
    void addMerchants();
    //按商品名排序并输出
    void gnamesort();
    //按商家名称排序并输出
    void mnamesort();
    //搜索
    void search(String s);
    //输出商家自己的商品
    void msearch();
    //实现购买功能
    void purchase(int id,int amount);
}
