package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ProductBasket {
    private List<Product> productList;

    public ProductBasket() {
        productList = new LinkedList<Product>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public int getCostProducts() {
        int result = 0;
        for (Product p : productList) {
            result += p.getPrice();
        }
        return result;
    }

    public void printCheck() {
        if (productList.size() == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product p : productList) {
            System.out.println(p.toString());
        }
        System.out.println("Итого: " + getCostProducts());
        System.out.println("Специальных товаров:\t" + getQuantitySpecialGoods());
    }

    public boolean isProduct(String title) {
        for (Product p : productList) {
            if (p.getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        productList.clear();
    }

    private int getQuantitySpecialGoods() {
        int count = 0;
        for (Product p : productList) {
            if (p != null && p.isSpecial()) {
                count++;
            }
        }
        return count;
    }

    public List<Product> delProducts(String name) {
        List<Product> result = new LinkedList<Product>();
        Iterator<Product> itr = productList.iterator();
        while (itr.hasNext()) {
            Product p = itr.next();
            if (p.getTitle().equals(name)) {
                result.add(p);
                productList.remove(p);
            }
        }
        return result;
    }
}
