package com.entity;

public class Goods{
    int id;
    String name;
    String price;
    String surplus;
    String merchantName;

    public Goods(int id, String name, String price, String surplus, String merchantName) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.surplus = surplus;
        this.merchantName = merchantName;
    }

    public Goods() {
    }

    @Override
    public String toString() {
        return id+" "+name+" "+price+" "+surplus+" "+ merchantName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSurplus() {
        return surplus;
    }

    public void setSurplus(String surplus) {
        this.surplus = surplus;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }
}
