package org.skypro.skyshop.product;

public abstract class Product {
    private String title;

    public abstract boolean isSpecial();

    public Product(String title) {
        if (title == null || title.trim().length() == 0) {
            throw new IllegalArgumentException("Проверьте вносимые сведения о товаре");
        }
        this.title = title.trim();
    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();
}
