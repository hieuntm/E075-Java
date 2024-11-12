package day16.sample.model;

public class OrderDetail {
    private int orderNumber;
    private String productCode;
    private int quantityOrdered;
    private double priceEach;
    private int orderLineNumber;

    public OrderDetail(String productCode, int quantityOrdered, double priceEach, int orderLineNumber) {
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public OrderDetail(int orderNumber, String productCode, int quantityOrdered, double priceEach, int orderLineNumber) {
        this.orderNumber = orderNumber;
        this.productCode = productCode;
        this.quantityOrdered = quantityOrdered;
        this.priceEach = priceEach;
        this.orderLineNumber = orderLineNumber;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public String getProductCode() {
        return productCode;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getPriceEach() {
        return priceEach;
    }

    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void display(){
        System.out.println("Product Code: " + productCode + " - Quantity Ordered: " + quantityOrdered + " - Price Each: " + priceEach + " - Order Line Number: " + orderLineNumber);
    }

}
