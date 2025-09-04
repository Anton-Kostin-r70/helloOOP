package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable, Comparable<Searchable> {
    private String title;
    protected String product = "PRODUCT";

    public abstract boolean isSpecial();

    public Product(String title) {
        if (title == null || title.isBlank()) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || !(o instanceof Searchable)) {
            return false;
        }
        return Objects.equals(title, getProductName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    public int compareTo(Searchable o) {
        return o.getProductName().length() - this.getProductName().length();
    }
}
