package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int basePrice;
    private int discountedPercent;
    private static final String DISCOUNTED_PRODUCT = "DISCOUNTED_PRODUCT";

    public DiscountedProduct(String title, int basePrice, int discountedPercent) {
        super(title);
        this.basePrice = basePrice;
        if (discountedPercent <= 0 || discountedPercent >= 100) {
            throw new IllegalArgumentException("Скидочный процент внесен не корректно 0..100%");
        }
        this.discountedPercent = discountedPercent;
        product = DISCOUNTED_PRODUCT;
    }

    @Override
    public int getPrice() {
        return basePrice * (1 - discountedPercent / 100);
    }

    @Override
    public String toString() {
        return getTitle() + ":\t" + getPrice() + " (" + discountedPercent + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
