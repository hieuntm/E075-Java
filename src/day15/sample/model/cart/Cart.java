package day15.sample.model.cart;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    // Hiện tại đang lưu vào ram, tức là nếu tắt chương trình thì mất hết
    private Map<String, Integer> cart = new HashMap<>();

    public void addProduct(String productCode, int quantity) {
        if (cart.containsKey(productCode)) {
            int currentQuantity = cart.get(productCode);
            cart.put(productCode, currentQuantity + quantity);
        } else {
            cart.put(productCode, quantity);
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
        System.out.println("Product Code  -  Quantity ");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public Map<String, Integer> getCart() {
        return cart;
    }

    public void setCart(Map<String, Integer> cart) {
        this.cart = cart;
    }
}
