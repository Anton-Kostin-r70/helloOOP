package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {
    private Map<String, List<Product>> products;

    public ProductBasket() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
    }

    public int getCostProducts() {
        return products.values().stream().flatMap(Collection::stream).mapToInt(Product::getPrice).sum();
    }

    public void printCheck() {
        if (products.isEmpty()) {
            System.out.println("В корзине пусто");
            return;
        }
        products.values().stream().flatMap(Collection::stream).forEach(System.out::println);
        System.out.println("Итого: " + getCostProducts() + "\nСпециальных товаров:\t" + getSpecialCount());
    }

    public boolean isProduct(String title) {
        return products.values().stream().flatMap(Collection::stream)
                .anyMatch((p) -> p.getTitle().equals(title));
    }

    public void clearBasket() {
        products.clear();
    }

    private long getSpecialCount() {
        long result = products.values().stream().flatMap(Collection::stream).filter(Product::isSpecial).count();
        return result;
    }

    public List<Product> delProducts(String title) {
        List<Product> result = products.values().stream().flatMap(Collection::stream).filter((p) -> {
            return p.getTitle().equals(title);
        }).collect(Collectors.toList());
        result.forEach((p) -> {
            products.remove(p.getTitle());
        });
        return result;
    }
}
