package ru.pavelnix.models;

/**
 * Класс, наследник от Item, определяет заявку - Корзина Покупок
 */
public class ShoppingBasket extends Item {
    private double price;

    public ShoppingBasket(String name, String description, long date, String authorId, double price) {
        super(name, description, date, authorId);
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}