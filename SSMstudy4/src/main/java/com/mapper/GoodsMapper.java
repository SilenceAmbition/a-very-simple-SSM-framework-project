package com.mapper;

import com.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    //查询全部商品
    List<Goods> search();
    //按商家名字查询商品
    List<Goods> Msearch(@Param("merchantName") String merchantName);
    void updateGoods(@Param("id") String id,@Param("name") String name,@Param("price") String price,@Param("surplus") String surplus);
    void deleteGoods(@Param("id") String id);
    void addGoods(@Param("id") int id,@Param("name") String name,@Param("price") String price,@Param("surplus") String surplus,@Param("merchantName") String merchantName);
    List<Goods> merchantNameSort();

    List<Goods> goodsNameSort();

    List<Goods> VisitsSort();
}
