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
        pb.addProduct(new SimpleProduct("bananas", 7));
        pb.addProduct(new FixPriceProduct("apples"));
        pb.addProduct(new DiscountedProduct("pears", 2, 50));
        pb.addProduct(new SimpleProduct("lemons", 7));
        pb.addProduct(new DiscountedProduct("eggs", 10, 20));
        List<Product> result = pb.delProducts("eggs");
        System.out.println(result.size() == 0 ? "Список пуст" : result);
        result = pb.delProducts("patato");
        System.out.println(result.size() == 0 ? "Список пуст" : result);

        SearchEngine se = new SearchEngine();
        se.add(new DiscountedProduct("pears", 2, 50));
        se.add(new SimpleProduct("lemons test", 7));
        try {
            se.add(new DiscountedProduct("eggs test test test", 10, 101));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        se.add(new Article("apples", "сочный плод яблони, который употребляется в пищу в свежем и" +
                " запечённом виде, служит сырьём в кулинарии и для приготовления напитков." +
                "test test testtest"));
        se.add(new Article("pineap", "The pineapple is indigenous to South America," +
                " where it has been cultivated for many centuries.test"));
        se.add(new Article("bananas", "Бананы — одна из древнейших пищевых культур, а для тропических" +
                " стран — важнейшее пищевое растение и главная статья экспорта.test"));
        System.out.println("Best result for the test:\n" + se.getBestResult("test"));
        try {
            System.out.println(se.getBestResult("555"));
        } catch (BestResultNotFound e) {
            e.printStackTrace();
        }
        System.out.println("Вывод результатов поиска - test:");
        for (Searchable s : se.search("test")) {
            System.out.println(s.getProductName());
        }
    }
}
