package day10.baitap.bai5trang88;

import java.io.*;
import java.util.HashMap;

public class StudentManagement {

    private final HashMap<String, Student> map;

    public StudentManagement() {
        map = new HashMap<>();
        // Import thường sau khi khởi tạo mảng/ collection thì chạy để lấy dữ liệu từ file
        importFromFile();

        // Export -> Sau khi tắt chương trình thì chạy

        // Hard code, default value
        // Bản chất là size map khi tạo ra, mặc định = 0
//        map.put("1", new Student("1", "Nguyen Van A", "Ha Noi", "0123456789"));
//        map.put("2", new Student("2", "Nguyen Van B", "Ha Noi", "0123456789"));
//        map.put("3", new Student("3", "Nguyen Van C", "Ha Noi", "0123456789"));
    }

    public int getSize() {
        return map.size();
    }

    // Nhập vào
    // Thêm vào map
    // Đây mới là dữ liệu chuẩn
    // Dữ liệu khởi tạo ở trên chỉ là dữ liệu mẫu
    // Khi mà dùng Collections -> Lưu ở memory -> Khi chương trình kết thúc -> Mất hết

    // Sinh ra file -> Lưu trữ dữ liệu, txt, dat, json, xml, csv, tsv, excel
    // Excel, Word -> Cần thư viện hỗ trợ apache poi

    // Sinh ra database -> Lưu trữ dữ liệu -> Database lớn -> trên 1tr dòng
    // Khi mà database lớn quá -> Data warehouse() -> Lớn hơn Database ->
    // Khi mà dữ liệu tạp nham quá, và cực kỳ nhiều -> Data Lake -> Big Data -> Hadoop, Kafka, Spark, ...
    public void add(Student student) {
    }

    // List, hay là Collection
    // Chỉ lưu khi mà ứng dụng chạy
    // Khi tắt ứng dụng, mất data, nên ngta sinh ra cái tính năng lưu trữ dữ liệu ra file
    // Khi chương trình chạy lại
    // Thì import, đọc từ file lưu vào collection.

    // Đọc từ file
    public void export() {
        // export ra file
        // .text, .dat, .ddl => Game, nhiều lắm
        // File text thuần (plain text)
        // .txt, .csv, .tsv => Dễ dùng
        // csv -> comma separated values
        // tsv -> tab separated values

        // BufferWriter, BufferReader
        String filename = "/Users/hieuntm/Documents/Java/working/GreenAcademy/src/day10/baitap/bai5trang88/data/student.txt";
        try {
            FileWriter fw = new FileWriter(filename); // Đối tượng để ghi vào
            BufferedWriter bw = new BufferedWriter(fw); // Ghi

            // Write là ghi ra file
            // Close để Đóng luồng ghi
            // Ghi title
            bw.write("ID,Name,Address,Phone Number\n");
            // Ghi từng item trong Collection
            for (Student student : map.values()) {
                // toString -> sout
                // bw.write(String): Nhận vào 1 string
                bw.write(student.toFile());
            }
            bw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // File binary (nhị phân)
        // Muốn dùng được thì phải biến object thành byte
        // và phải implement Serializable
        // InputStream, và OutputStream

    }

    public void importFromFile() {
        String filename = "/Users/hieuntm/Documents/Java/working/GreenAcademy/src/day10/baitap/bai5trang88/data/student.txt";
        try {
            FileReader fw = new FileReader(filename); // Đối tượng để ghi vào
            BufferedReader bw = new BufferedReader(fw); // Ghi

            // Đọc từng dòng 1 lần
//            String line = bw.readLine();
            String line;
//            if(line != null){
            // xử lý từng dòng 1,
            // rồi đọc tiếp
            // đâu có biết số lượng line của 1 file đâu
            // nên mới dùng while
//            }

            int count = 0;
            while ((line = bw.readLine()) != null) {
                if(count == 0){
                    count++;
                    continue;
                }
                System.out.println("Line: " + count + ":" + line);
                count++;

                // Xử lý cái line này, ép thành object. rồi thêm lại vào Collection
                // tsv, csv -> , và \t (Delimiter) -> Dùng split cắt theo delimiter(dấu phẩy, or \tab)

                // Ví dụ:  1,Nguyen Van A,Ha Noi,0123456789
                // Sau khi cắt dấu phẩy, ra mảng String
                // Index 0: 1
                // Index 1: Nguyen Van A
                // Index 2: Ha Noi
                // Index 3: 0123456789

                line = line.trim(); // Cắt đầu, đuôi
                String[] data = line.split(",");
                // Cắt bởi dấu , -> Mảng String
                // Mặc định ra size = 4.
                String id = data[0];
                String name = data[1];
                String address = data[2];
                String phoneNumber = data[3];
                Student student = new Student(id, name, address, phoneNumber);
                map.put(id, student);
            }

            bw.close();

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
