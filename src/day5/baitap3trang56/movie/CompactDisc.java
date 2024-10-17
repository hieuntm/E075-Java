package day5.baitap3trang56.movie;

public class CompactDisc {

    // Cach tao class data
    // 1. Private variable
    // 2. Constructor (Default + Parameterized(Full))
    // 3. Getter/Setter
    // 4. toString
    private String title;
    private double price;
    private String code;

    public CompactDisc() {
        // Default constructor
        // Tạo ra object trắng or rỗng
        // Và mình sẽ sử dụng setter để cập nhật dữ liệu cho nó
    }

    public CompactDisc(String title, double price, String code) {
        this.title = title;
        this.price = price;
        this.code = code;
        // Chứa đẩy thông tin của các trường
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "CompactDiscMovie{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                '}';
    }
}
