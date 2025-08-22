package org.skypro.skyshop.product;

public class Product {
    private String title;
    private int price;

    public Product(String title, int price) {
        if (price <= 0 || title == null) {
            throw new IllegalArgumentException("Проверьте вносимые сведения о товаре");
        }
        this.title = title;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }
}
