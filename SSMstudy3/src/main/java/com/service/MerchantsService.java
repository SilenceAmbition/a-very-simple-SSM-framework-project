package com.service;

import com.entity.Merchants;
import com.mapper.MerchantsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantsService {
    @Autowired
    private MerchantsMapper merchantsMapper;    //引用dao层

    public Merchants login(String name,String password){   //创建这个方法给controller层调用
        Merchants login=merchantsMapper.login(name,password);   //调用dao层的方法   获得前端发来的数据
        return login;
    }

}
