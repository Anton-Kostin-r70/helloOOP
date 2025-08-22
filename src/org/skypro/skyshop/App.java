package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        ProductBasket pb = new ProductBasket();
        pb.addProduct(new Product("bananas", 5));
        pb.addProduct(new Product("apples", 1));
        pb.addProduct(new Product("pears", 2));
        pb.addProduct(new Product("lemons", 7));
        pb.addProduct(new Product("eggs", 10));
        pb.addProduct(new Product("sausages", 50));
        pb.printCheck();
        System.out.println("Стоимость корзины с несколькими товарами:" + pb.getCostProducts());
        System.out.println(pb.isProduct("apples") ? "apples есть в корзине" : "apples нет в корзине");
        System.out.println(pb.isProduct("sausages") ? "sausages есть в корзине" : "sausages нет в корзине");
        pb.cleanBasket();
        pb.printCheck();
        System.out.println("Стоимость пустой корзины:" + pb.getCostProducts());
        System.out.println(pb.isProduct("apples") ? "apples есть в корзине" : "apples нет в корзине");
    }
}
