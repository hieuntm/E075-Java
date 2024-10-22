package day7.bai2trang77;

public class Employee {

    private String name;
    private String address;
    private String phoneNumber;

    public Employee() {
    }

    public Employee(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String standardizeAddress() {
        // Chuyển "Drive" -> "D"
        // Chuyển "Road" -> "R"
        // Chuyển "Street" -> "S"
        String chuoi = address;
        chuoi = chuoi.replaceAll("\\s+", "");
        chuoi = chuoi.replaceAll("Drive", "D");
        chuoi = chuoi.replaceAll("Road", "R");
        chuoi = chuoi.replaceAll("Street", "S");
        return chuoi;
    }

    public String standardizePhoneNumber() {
        // Chuyển "delimeter" -> "-"
        String chuoi = phoneNumber;
        chuoi = chuoi.replaceAll("\\s+", "-");
        chuoi = chuoi.replaceAll(",", "-");
        return chuoi;
    }
}
