package day8.bai1trang84.management;

import day8.bai1trang84.data.Product;
import day8.bai1trang84.data.ProductComparator;

import java.util.ArrayList;
import java.util.List;

import static day8.bai1trang84.util.InputUtils.inputDigit;
import static day8.bai1trang84.util.InputUtils.inputString;

public class ProductManagement {

    private final List<Product> prList;

    public ProductManagement() {
        prList = new ArrayList<>();
        prList.add(new Product("SPT001", "Iphone 12", 2000));
        prList.add(new Product("SPT002", "Samsung S21", 3000));
        prList.add(new Product("SPT003", "Xiaomi 10", 1000));
        prList.add(new Product("SPT004", "Oppo F11", 500));
        prList.add(new Product("SPT005", "Vivo V20", 700));
        prList.add(new Product("SPT006", "Realme 7", 800));
        prList.add(new Product("SPT007", "Nokia 8.3", 900));
        prList.add(new Product("SPT008", "Huawei P40", 1200));
        prList.add(new Product("SPT009", "Sony Xperia 1", 1500));
    }

    public List<Product> getPrList() {
        return prList;
    }

    private int id = 1;

    // Function 1
    // Thêm sản phẩm
    public void addProduct() {
        String newId = "SP000" + this.id++;
        // id -> SP0001, SP0003, SP004
        String name = inputString("Nhập Tên sản phẩm: ");
        int unitPrice = inputDigit(50, Integer.MAX_VALUE, "Nhập giá sản phẩm: ");

        Product newProduct = new Product(newId, name, unitPrice);
        prList.add(newProduct);
    }

    // Function 2
    // Tìm sản phẩm theo id
    // trả về true false
    public boolean searchById() {
        String inputId = inputString("Nhập mã ID sản phẩm cần tìm: ");
        // Cách 1
        for (Product prd : prList) {
            if (prd.getId().equals(inputId)) {
                return true;
            }
        }
        // Cách 2
//        for (int i = 0; i < prList.size(); i++) {
//            // i là index
//            Product product = prList.get(i);
//            if(product.getId().equals(inputId)){
//                return true;
//            }
//        }
        return false;
    }

    // Alter
    public int searchByIdReturnIndex() {
        String inputId = inputString("Nhập mã ID sản phẩm cần tìm: ");
        for (int i = 0; i < prList.size(); i++) {
            Product product = prList.get(i);
            if (product.getId().equals(inputId)) {
                return i; // index
            }
        }
        return -1;
    }

    // Function 3
    // Hiển thị toàn bộ sản phẩm
    public void displayProduct(List<Product> listDisplay) {
        System.out.println("-------------------------------------------------");
        System.out.println("Danh sách sản phẩm: ");
        // Tên header, nên fix sẵn
        System.out.printf("%10s%20s%21s", "ID", "Tên sản phẩm", "Giá sản phẩm\n");
        // Cách 1
//        for (Product product : prList) {
//            System.out.println(product);
//        }

        // Cách 2
        for (int i = 0; i < listDisplay.size(); i++) {
            // i là index
            Product product = listDisplay.get(i);
            display(product);
        }
        System.out.println("-------------------------------------------------");
        System.out.printf("%50s", "Total products: " + listDisplay.size() + "\n");
    }

    // Hàm mini, tái sử dụng
    // Hiển thị 1 sản phẩm
    public void display(Product product){
        System.out.println(product);
    }

    // Nếu mà có lỗi, nên extends exception => Throw nhìn cho chuyên nghiệp

    // Function 4
    // Xoá sản phẩm theo id
    public void deleteProduct() {
        // 1. Nhập id cần xoá
        // 2. Tìm sản phẩm có id đó
        // 3. Nếu tìm thấy thì xoá
        // 4. Nếu không tìm thấy thì thông báo không tìm thấy (lỗi)
        int isFoundIndex = searchByIdReturnIndex();
        if (isFoundIndex == -1) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        prList.remove(isFoundIndex);
        System.out.println("Xoá sản phẩm thành công tại index: " + isFoundIndex);
    }

    // Function 5
    // Yêu cầu nhập id
    // Tìm sản phẩm
    // Nếu có thì hiển thị nó ra
    // Nếu không thì thông báo không tìm thấy
    public void displaySingleProductById(){
        int isFoundIndex = searchByIdReturnIndex();
        if (isFoundIndex == -1) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        Product product = prList.get(isFoundIndex);
        display(product);
    }

    // Function 6/7 -> giống nhau
    // Sort
    // 1. Clone mảng khác
    // 2. sort
    // 3. display
    // vì hàm tái sử dụng, nên có parameter
    public void sort(boolean isAsc){
        // Clone mảng
        List<Product> cloneList = new ArrayList<>(prList);
        // Sort
        ProductComparator comparator = new ProductComparator();
        //
        if(isAsc){
            cloneList.sort(comparator.new SortByPriceAscending());
        } else {
            cloneList.sort(comparator.new SortByPriceDescending());
        }
        // Display
        displayProduct(cloneList);
    }

    // Function 8
    // Cập nhập sản phẩm
    public void updateProduct(){
        int isFoundIndex = searchByIdReturnIndex();
        if (isFoundIndex == -1) {
            System.out.println("Không tìm thấy sản phẩm");
            return;
        }
        Product product = prList.get(isFoundIndex);
        String name = inputString("Nhập Tên sản phẩm: ");
        int unitPrice = inputDigit(50, Integer.MAX_VALUE, "Nhập giá sản phẩm: ");
        product.setName(name);
        product.setUnitPrice(unitPrice);
        System.out.println("Cập nhật sản phẩm thành công");
    }

    // Function 9
    // Hiển thị sản phẩm trong tầm giá
    public void displayProductByPriceRange(){
        int minPrice = inputDigit(50, Integer.MAX_VALUE, "Nhập giá sản phẩm tối thiểu: ");
        int maxPrice = inputDigit(minPrice, Integer.MAX_VALUE, "Nhập giá sản phẩm tối đa: ");

        // display cho function này thôi
        List<Product> listDisplay = new ArrayList<>();
        for(Product product : prList){
            if(product.getUnitPrice() >= minPrice && product.getUnitPrice() <= maxPrice){
                listDisplay.add(product);
            }
        }
        displayProduct(listDisplay);
        System.out.println("-------------------------------------------------");
    }


}
