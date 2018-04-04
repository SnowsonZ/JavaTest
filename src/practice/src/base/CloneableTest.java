package practice.src.base;

import practice.src.bean.Cart;
import practice.src.bean.Product;

/**
 * @Author: Snowson
 * @Date: 2018/4/3 11:01
 * @Description:
 */
public class CloneableTest {
    public static void main(String[] args) {
        Product product = new Product("cherry keyboard", 100001, 0);
        Product copyProduct = (Product) product.clone();
        System.out.println("== " + (copyProduct == product));
        System.out.println("class " + (copyProduct.getClass() == product.getClass()));
        System.out.println("equals" + copyProduct.equals(product));

        Cart cart = new Cart();
        for (int i = 0; i < 3; i++) {
            Product p = new Product("cherry", i, i);
            cart.getProducts().add(p);
        }
        cart.setCount(cart.getProducts().size());
        cart.setPrice(234.12f);
        //HashMap
        cart.getParams().put("type", "1");
        cart.getParams().put("size", "32");

        Cart copyCart = cart.clone();
        Cart copyCart1 = cart;
        System.out.println("update before");
        System.out.println("== " + (copyCart == cart));
        System.out.println("class " + (copyCart.getClass() == cart.getClass()));
        System.out.println("equals " + copyCart.equals(cart));
        cart.setPrice(100.23f);
        System.out.println("update after");
        System.out.println("== " + (copyCart == cart));
        System.out.println("class " + (copyCart.getClass() == cart.getClass()));
        System.out.println("equals " + copyCart.equals(cart));

        //change hashmap
        cart.getParams().remove("type");
    }
}
