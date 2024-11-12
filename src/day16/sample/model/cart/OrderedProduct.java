package day16.sample.model.cart;

public class OrderedProduct {

    // muốn thông tin gì thêm thì thêm fields/ trường/ thuộc tính vào
    private int quantity;
    private double priceEach;

    public OrderedProduct(int quantity, double priceEach) {
        this.quantity = quantity;
        this.priceEach = priceEach;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(double priceEach) {
        this.priceEach = priceEach;
    }
}
