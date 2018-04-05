package com.snowson.practice.bean;

/**
 * @Author: Snowson
 * @Date: 2018/4/3 11:02
 * @Description:
 */
public class Product implements Cloneable {
    private String name;
    private long id;
    private int type;

    public Product() {
    }

    public Product(String name, long id, int type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Product)) {
            return false;
        }
        Product product = (Product) obj;
        return product.getId() == this.getId() && product.getName().equals(this.getName())
                && product.getType() == this.getType();
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}
