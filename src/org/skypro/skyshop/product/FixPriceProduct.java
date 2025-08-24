package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIX_PRICE_PRODUCT = 50;

    public FixPriceProduct(String title) {
        super(title);
    }

    @Override
    public int getPrice() {
        return FIX_PRICE_PRODUCT;
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена\t" + FIX_PRICE_PRODUCT;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
