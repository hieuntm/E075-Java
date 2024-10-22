package day7.bai2trang77;

public class Administrator {
    public static void main(String[] args) {
        Employee employee = new Employee("Nguyen Van A", "123 Drive, 456 Road, 789 Street ABC", "123,456,7890");
        System.out.println(employee.standardizeAddress());
        System.out.println(employee.standardizePhoneNumber());

    }
}
