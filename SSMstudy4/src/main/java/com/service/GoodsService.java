package com.service;

import com.entity.Goods;
import com.mapper.GoodsMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;

    public List<Goods> search(){
        List<Goods> goodsList = goodsMapper.search();
        return goodsList;
    }
    public List<Goods> Msearch(String merchantName){
        List<Goods> mGoodsList = goodsMapper.Msearch(merchantName);
        return mGoodsList;
    }
    public void updateGoods(String id,String name, String price,String surplus) {
        goodsMapper.updateGoods(id,name,price,surplus);
    }
    public void deleteGoods(String id) {
        goodsMapper.deleteGoods(id);
    }
    public void addGoods(int id,String name, String price,String surplus,String merchantName) {
        goodsMapper.addGoods(id,name, price, surplus,merchantName);
    }
    public List<Goods> merchantNameSort(){
        List<Goods> goodsList = goodsMapper.merchantNameSort();
        return goodsList;
    }
    public List<Goods> goodsNameSort(){
        List<Goods> goodsList = goodsMapper.goodsNameSort();
        return goodsList;
    }
    public List<Goods> VisitsSort(){
        List<Goods> goodsList = goodsMapper.VisitsSort();
        return goodsList;
    }

}
