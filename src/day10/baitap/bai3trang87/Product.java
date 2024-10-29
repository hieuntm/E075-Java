package day10.baitap.bai3trang87;

import java.util.Objects;

public class Product implements Comparable{

    private String id, name, country;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String country, double price) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.price = price;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }

    // Function nó quyết định việc so sánh giữa 2 object, hoặc 1 list object với nhau
//    @Override
//    public boolean equals(Object o) {
//        // function này trả về boolean
//        // Nếu giá trị return nó true => 2 object giống nhau
//        // Nếu giá trị return nó false => 2 object khác nhau
//        // Nó quyết định xem có push đc 1 object vào set, hashset hay không
//
//        // Tham số Object o => Là đối tượng được so sánh với object Product
//        // this trong trường hợp này là object Product hiện tại
//        if (o == null || getClass() != o.getClass()) return false;
//        Product product = (Product) o;
//        return Objects.equals(id, product.id);
//    }
//
//    @Override
//    public int hashCode() {
//        // Function này trả về 1 số nguyên
//        // Dựa vào các tham số truyền vào
//        // Ví dụ: id, name, country, price
//        return Objects.hash(id, name, country, price); // => Đổi thuộc tính thành int -> Compare
//    }
}
