package day8.bai1trang84.data;

public class Product {

    private String id;
    private String name;
    private int unitPrice;

    public Product() {
    }

    public Product(String id, String name, int unitPrice) {
        this.id = id;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        // Từng sản phẩm, từng record
        return String.format("%10s%20s%20s", id, name, unitPrice);
    }
}
