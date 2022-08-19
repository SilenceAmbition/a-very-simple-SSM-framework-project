package com.entity;

public class Goods{
    int id;
    String name;
    String price;
    String surplus;
    String shopername;

    public Goods(int id, String name, String price, String surplus, String shopername) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.surplus = surplus;
        this.shopername = shopername;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", surplus='" + surplus + '\'' +
                ", shopername='" + shopername + '\'' +
                '}';
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

    public String getShopername() {
        return shopername;
    }

    public void setShopername(String shopername) {
        this.shopername = shopername;
    }
}
