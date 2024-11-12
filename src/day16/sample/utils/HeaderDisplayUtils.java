package day16.sample.utils;

public class HeaderDisplayUtils {
    public static void displayProductHeader() {
        // Header
        System.out.println("-- Account list: --");
        System.out.printf("%20s%50s%20s%12s%25s%18s%12s\n", "Code", "Name", "prdLine", "Scale", "Vendor", "Quantity", "Buy Price");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void displayAccountHeader() {
        // Header
        System.out.println("-- Account list: --");
        System.out.printf("%20s%10s\n", "Username", "Role");
        System.out.println("-------------------------------------------------------------------------------------------------------");
    }
}
