package org.skypro.skyshop.description;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

public class Article implements Searchable {
    private String title;
    private String description;
    private static final String ARTICLE = "ARTICLE";

    public Article(String title, String description) {
        if (title == null || title.trim().length() == 0 || description == null || description.trim().length() == 0) {
            throw new IllegalArgumentException("Проверьте вносимые сведения в описании");
        }
        this.title = title;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " : " + description;
    }

    // Метод получения search term
    public String getSeachTerm(String term) {
        return toString().replace('\n', '\s') + " - " + ARTICLE;
    }

    //Метод получения типа контента
    public String getContentType() {
        return ARTICLE;
    }

    //Метод получения имени объекта
    public String getProductName() {
        return getTitle();
    }
    public String getStringRepresentation() {
        return getTitle() + " - " + ARTICLE;
    }
}
