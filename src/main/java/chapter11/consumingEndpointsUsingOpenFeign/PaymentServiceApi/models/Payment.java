package chapter11.consumingEndpointsUsingOpenFeign.PaymentServiceApi.models;

public class Payment {
    // Attributes
    private String id;
    private double amount;

    // Getters and Setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
