package org.skypro.skyshop.product;

public interface Searchable {
    // Метод получения search term
    public String getSeachTerm(String term);

    //Метод получения типа контента
    String getContentType();

    //Метод получения имени объекта
    String getProductName();

    public default String getStringRepresentation() {
        return "имя Searchable-объекта - тип Searhable-объекта";
    }
}
