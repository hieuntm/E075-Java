package day10.baitap.bai5trang88;

import java.io.*;
import java.util.HashMap;

public class StudentManagementClean {

    private final String STORE_FILE = "/Users/hieuntm/Documents/Java/working/GreenAcademy/src/day10/baitap/bai5trang88/data/student.txt";
    private final HashMap<String, Student> map;

    public StudentManagementClean() {
        map = new HashMap<>();
        importFromFile();
    }

    public int getSize() {
        return map.size();
    }

    public void add(Student student) {
    }

    public void export() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(STORE_FILE))) {
            bw.write("ID,Name,Address,Phone Number\n"); // Header, title
            for (Student student : map.values()) { // Loop, viết từng thằng ra file 1
                bw.write(student.toFile());
            }
        } catch (IOException ex) {
            // Xảy ra trong trường hợp
            // 1. Ko có file
            // 2. File ko có permits
            System.out.println(ex.getMessage());
        }
    }

    public void importFromFile() {
        try (BufferedReader bw = new BufferedReader(new FileReader(STORE_FILE))) {
            String line;
            int count = 0;
            while ((line = bw.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if(id.equals("ID")){
                    continue;
                }
                String name = data[1];
                String address = data[2];
                String phoneNumber = data[3];
                Student student = new Student(id, name, address, phoneNumber);
                map.put(id, student);
                count++;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
