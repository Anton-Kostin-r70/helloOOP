package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private Product[] productList = new Product[5];
    private int numberOfProducts = 0;

    public void addProduct(Product product) {
        if (productList.length == numberOfProducts) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        productList[numberOfProducts] = product;
        numberOfProducts++;
    }

    public int getCostProducts() {
        int result = 0;
        for (int i = 0; i < numberOfProducts; i++) {
            result += productList[i].getPrice();
        }
        return result;
    }

    public void printCheck() {
        if (numberOfProducts == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (int i = 0; i < numberOfProducts; i++) {
            System.out.println(productList[i].toString());
        }
        System.out.println("Итого: " + getCostProducts());
        System.out.println("Специальных товаров:\t" + getQuantitySpecialGoods());
    }

    public boolean isProduct(String title) {
        for (int i = 0; i < numberOfProducts; i++) {
            if (productList[i].getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    public void cleanBasket() {
        for (int i = 0; i < numberOfProducts; i++) {
            productList[i] = null;
        }
        numberOfProducts = 0;
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
}
