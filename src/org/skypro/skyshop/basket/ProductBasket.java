package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productList;

    public ProductBasket() {
        productList = new HashMap<>();
    }

    public void addProduct(Product product) {
        productList.computeIfAbsent(product.getTitle(), k -> new ArrayList<>()).add(product);
    }

    public int getCostProducts() {
        int result = 0;
        for (String k : productList.keySet()) {
            for (Product p : productList.get(k)) {
                result += p.getPrice();
            }
        }
        return result;
    }

    public void printCheck() {
        if (productList.size() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (String k : productList.keySet()) {
            for (Product p : productList.get(k)) {
                System.out.println(p.toString());
            }
        }
        System.out.println("Итого: " + getCostProducts());
        System.out.println("Специальных товаров:\t" + getQuantitySpecialGoods());
    }

    public boolean isProduct(String title) {
        for (String k : productList.keySet()) {
            for (Product p : productList.get(k)) {
                if (p.getTitle().equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void clearBasket() {
        productList.clear();
    }

    private int getQuantitySpecialGoods() {
        int count = 0;
        for (String k : productList.keySet()) {
            for (Product p : productList.get(k)) {
                if (p != null && p.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    public List<Product> delProducts(String name) {
        List<Product> result = new LinkedList<Product>();
        if (productList.containsKey(name)) {
            Iterator<Product> itr = (productList.get(name)).iterator();
            while (itr.hasNext()) {
                Product p = itr.next();
                if (p.getTitle().equals(name)) {
                    result.add(p);
                    productList.remove(p);
                }
            }
        }
        return result;
    }
}
