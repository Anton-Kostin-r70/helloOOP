package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;
    public SimpleProduct(String title, int price) {
        super(title);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена на товар не может быть отрицательной");
        }
        this.price = price;
    }
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getTitle() + ":\t" + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}
