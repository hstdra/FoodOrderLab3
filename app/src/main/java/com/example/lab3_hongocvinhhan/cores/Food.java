package com.example.lab3_hongocvinhhan.cores;

public class Food {
    private int id;
    private String name;
    private int price;
    private String image;
    private int quantity = 1;

    public Food(String name, int price, String image) {
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public Food(int id, String name, int price, String image) {
        this(name, price, image);
        this.id = id;
    }

    public Food(int id, String name, int price, String image, int quantity) {
        this(id, name, price, image);
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void plus(int count) {
        this.quantity = this.quantity + count;
    }

    public void subtract() {
        this.quantity = this.quantity <= 1 ? 1 : this.quantity - 1;
    }

    public void reset() {
        this.quantity = 1;
    }
}
