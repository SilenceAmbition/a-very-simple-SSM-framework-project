package com;

import com.mapper.GoodsMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;


public class Main {
    @Test
    public static void main(String[] args) throws IOException {
            InputStream is=Resources.getResourceAsStream("spring-mybatis.xml");//mabatis配置文件
            SqlSessionFactoryBuilder SqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
            SqlSessionFactory SqlSessionFactory = SqlSessionFactoryBuilder.build(is);
            SqlSession sqlSession = SqlSessionFactory.openSession();
            GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);   //获得接口
            sqlSession.commit();
            int rush = mapper.addGoods();                                   //获得接口，调用接口方法
            System.out.println("result:"+rush);                             //其他内容复制期可
            sqlSession.commit();



    }
}