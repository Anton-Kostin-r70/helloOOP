package org.skypro.skyshop.product;

public abstract class Product implements Searchable {
    private String title;
    protected String product = "PRODUCT";

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

    public String getSeachTerm(String term) {
        return title;
    }

    public String getContentType() {
        return product;
    }

    public String getProductName() {
        return getTitle();
    }

    public String getStringRepresentation() {
        return this != null ? getTitle() + " - " + product : "";
    }
}
