package day4.oop;

public class Encapsulation {

    class Account {
        private String username;
        private String password;
        private String email;
        private String phoneNumber;

        public String getPassword() {
            String md5;// mã hóa password

            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }


    // OOP -> Object Oriented Programming
    // Lập trình hướng đối tượng.....
    // 1. Class: Lớp
    // 2. Object: Đối tượng

    // 4 thuộc tính
    // 1. Encapsulation: Bao đóng
    // 2. Inheritance: Kế thừa
    // 3. Polymorphism: Đa hình
    // 4. Abstraction: Trừu tượng

    public static void main(String[] args) {
        Mage mage = new Mage();
        mage.hp = 200;
//        mage.mana // ko access được//
        mage.getMana();
        mage.setMana(200);
    }
}
