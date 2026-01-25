package chapter08.usingDifferentHttpMethods.model;

public class Product {
    // Attributes
    private String name;
    private double price;

    // Constructor
    public Product(double price, String name) {
        this.price = price;
        this.name = name;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
