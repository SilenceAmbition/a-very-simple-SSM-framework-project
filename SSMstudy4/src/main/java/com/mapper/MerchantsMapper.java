package com.mapper;

import com.entity.Merchants;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.util.List;


//这个接口中的一个方法是网站的一个需要执行sql的操作，这些方法获得网站返回的数据并给service层调用
public interface MerchantsMapper {

    //商家登入
    Merchants login(@Param("name") String name, @Param("password") String password);   //@Param("password")指定参数名字为password，在使用sql语句时可以用password作占位符，表示参数password




}
