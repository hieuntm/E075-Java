package day5.baitap3trang56.music;

public class CompactDisc {

    // Cach tao class data
    // 1. Private variable
    // 2. Constructor (Default + Parameterized(Full))
    // 3. Getter/Setter
    // 4. toString
    private String title;
    private String artist;
    private double price;
    private String code;
    public int index = 0;

    public CompactDisc() {
        // Default constructor
        // Tạo ra object trắng or rỗng
        // Và mình sẽ sử dụng setter để cập nhật dữ liệu cho nó
    }

    public CompactDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;

        // Chứa 1 phần dữ liệu
        // Trường nào được set thì có dữ liệu
    }

    public CompactDisc(String title, String artist, double price, String code) {
        this.title = title;
        this.artist = artist;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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
        return "CompactDisc{" +
                "title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                ", index=" + index +
                '}';
    }
}
