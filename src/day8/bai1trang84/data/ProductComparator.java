package day8.bai1trang84.data;

import java.util.Comparator;

public class ProductComparator {
    //ascending - sắp xếp tăng dần
    // descending - sắp xếp giảm dần
    public class SortByPriceAscending implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            // trả về âm
            // trả về 0
            // trả về dương
            // Muốn tăng dần, thì o1 > o2
            // Muốn giảm dần thì o2 > o1
            return o1.getUnitPrice() - o2.getUnitPrice();
        }
    }

    public class SortByPriceDescending implements Comparator<Product> {
        @Override
        public int compare(Product o1, Product o2) {
            // trả về âm
            // trả về 0
            // trả về dương
            // Muốn tăng dần, thì o1 > o2
            // Muốn giảm dần thì o2 > o1
            return o2.getUnitPrice() - o1.getUnitPrice();
        }
    }
}
