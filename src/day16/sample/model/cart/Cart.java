package day16.sample.model.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    // Hiện tại đang lưu vào ram, tức là nếu tắt chương trình thì mất hết
    private Map<String, OrderedProduct> cart = new HashMap<>();

    // Muốn lưu các thông tin, như kiểu giá cả, quantity

    public void addProduct(String productCode, int quantity, double price) {
        if (cart.containsKey(productCode)) {
            OrderedProduct currentOrderedProduct = cart.get(productCode);
            // Chứa thông tin quantity và price
            // sửa or thêm quantity => lấy lại quantity cũ, rồi cộng thêm
            int currentQuantity = currentOrderedProduct.getQuantity();

            currentOrderedProduct.setQuantity(currentQuantity + quantity);
            cart.put(productCode, currentOrderedProduct);
        } else {
            OrderedProduct orderedProduct = new OrderedProduct(quantity, price);
            cart.put(productCode, orderedProduct);
        }
        System.out.println("Thêm sản phẩm vào giỏ hàng thành công");
    }

    public void removeProduct(String productCode) {
        if (cart.containsKey(productCode)) {
            cart.remove(productCode);
        }
        System.out.println("Xóa sản phẩm khỏi giỏ hàng thành công");
    }

    public void clearCart() {
        cart.clear();
        System.out.println("Clear giỏ hàng");
    }

    public void displayCart() {
        System.out.println("------- Cart: ");
        System.out.println("Product Code  -  Quantity  -  Price");
        for (Map.Entry<String, OrderedProduct> entry : cart.entrySet()) {
            // entry nó trả về 1 cặp key, value
            // dùng entry.getKey để trả về key
            // entry.getValue trả về value
            OrderedProduct orderedProduct = entry.getValue();
            System.out.println(entry.getKey() + " - " + orderedProduct.getQuantity() + " -  $" + orderedProduct.getPriceEach());
        }
    }

    public Map<String, OrderedProduct> getCart() {
        return cart;
    }

    public void setCart(Map<String, OrderedProduct> cart) {
        this.cart = cart;
    }
}
