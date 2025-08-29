package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.description.Article;
import org.skypro.skyshop.exception.BestResultNotFound;
import org.skypro.skyshop.product.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ProductBasket pb = new ProductBasket();
        pb.addProduct(new SimpleProduct("bananas", 5));
        pb.addProduct(new FixPriceProduct("apples"));
        pb.addProduct(new DiscountedProduct("pears", 2, 50));
        pb.addProduct(new SimpleProduct("lemons", 7));
        pb.addProduct(new DiscountedProduct("eggs", 10, 20));
        List<Product> result = pb.delProducts("eggs");
        System.out.println(result.size() == 0 ? "Список пуст" : result);
        result = pb.delProducts("patato");
        System.out.println(result.size() == 0 ? "Список пуст" : result);

        SearchEngine se = new SearchEngine();
        se.add(new SimpleProduct("bananas test", 5));
        se.add(new FixPriceProduct("apples"));
        se.add(new DiscountedProduct("pears test test", 2, 50));
        se.add(new SimpleProduct("lemons", 7));
        try {
            se.add(new DiscountedProduct("eggs test test test", 10, 101));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        se.add(new Article("bananas", "Бананы — одна из древнейших пищевых культур, а для тропических" +
                " стран — важнейшее пищевое растение и главная статья экспорта."));
        se.add(new Article("apples", "сочный плод яблони, который употребляется в пищу в свежем и" +
                " запечённом виде, служит сырьём в кулинарии и для приготовления напитков." +
                "test test testtest"));
        System.out.println(se.getBestResult("test"));
        try {
            System.out.println(se.getBestResult("555"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }
    }
}
