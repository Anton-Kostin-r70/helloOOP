package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        ProductBasket pb = new ProductBasket();
        pb.addProduct(new SimpleProduct("bananas", 5));
        pb.addProduct(new FixPriceProduct("apples"));
        pb.addProduct(new DiscountedProduct("pears", 2, 50));
        pb.addProduct(new SimpleProduct("lemons", 7));
        pb.addProduct(new DiscountedProduct("eggs", 10, 50));
        pb.printCheck();
    }
}
