package com.mapper;

import com.entity.Merchants;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;



public interface MerchantsMapper {
    //这个方法是网站的一个操作，即登入操作，创建这个方法获得网站返回的数据并给service层调用
    Merchants login(@Param("name") String name, @Param("password") String password);   //@Param("password")指定参数名字为password，在使用sql语句时可以用password作占位符，表示参数password



}
