package practice.src.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: Snowson
 * @Date: 2018/4/3 11:26
 * @Description:
 */
public class Cart implements Cloneable {
    private int count;
    private float price;
    private List<Product> products = new ArrayList<>();
    private HashMap<String, String> params = new HashMap<>();

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public Cart clone() {
        try {
            return (Cart) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) obj;
        return cart.getPrice() == this.getPrice() && cart.getProducts().equals(this.getProducts())
                && cart.getCount() == this.getCount();
    }
}
