package org.skypro.skyshop;

import org.skypro.skyshop.description.Article;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SearchEngine;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SearchEngine se = new SearchEngine(15);
        se.add(new SimpleProduct("bananas", 5));
        se.add(new FixPriceProduct("apples"));
        se.add(new DiscountedProduct("pears", 2, 50));
        se.add(new SimpleProduct("lemons", 7));
        se.add(new DiscountedProduct("eggs", 10, 50));
        se.add(new Article("bananas", "Бананы — одна из древнейших пищевых культур, а для тропических" +
                " стран — важнейшее пищевое растение и главная статья экспорта."));
        se.add(new Article("apples", "сочный плод яблони, который употребляется в пищу в свежем и" +
                " запечённом виде, служит сырьём в кулинарии и для приготовления напитков."));
        System.out.println((Arrays.toString(se.search("служит сырьём"))));
        System.out.println(Arrays.toString(se.search("bananas")));
    }
}
