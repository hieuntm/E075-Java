package day5.baitap3trang56.customer;

import day5.baitap3trang56.movie.CompactDisc;

import java.util.Scanner;

public class CDCreator {
    // Cả 2 mảng đều giới hạn ở 10
    int MAX_SIZE = 2;

    int nextMovie = 0;
    int maxMovie = MAX_SIZE;

    int nextMusic = 0;
    int maxMusic = MAX_SIZE;

    // Movie
    CompactDisc[] vcd = new CompactDisc[maxMovie];

    // Music
    day5.baitap3trang56.music.CompactDisc[] cd = new day5.baitap3trang56.music.CompactDisc[maxMusic];


    void displayAllMusic() {
        for (int i = 0; i < maxMusic; i++) {
            day5.baitap3trang56.music.CompactDisc compactDisc = cd[i];
            System.out.println(compactDisc);
        }
    }

    void displayAllMovie() {
        for (int i = 0; i < maxMovie; i++) {
            CompactDisc compactDisc = vcd[i];
            System.out.println(compactDisc);
        }
    }


    Scanner sc;

    void addMovie() {
        sc = new Scanner(System.in);
        if (nextMovie == maxMovie) {
            System.out.println("Movie is full");
            return;
        }
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();
        // Đây là đối tượng được tạo mới thông qua constructor, dữ liệu lấy từ bàn phím
        CompactDisc compactDisc = new CompactDisc(title, price, code);
        vcd[nextMovie] = compactDisc;
        nextMovie++;
        System.out.println("Add movie successfully");
    }

    void addMusic() {
        sc = new Scanner(System.in);
        if (nextMusic == maxMusic) {
            System.out.println("Music is full");
            return;
        }
        System.out.println("Enter title: ");
        String title = sc.nextLine();
        System.out.println("Enter artist: ");
        String artist = sc.nextLine();
        System.out.println("Enter code: ");
        String code = sc.nextLine();
        System.out.println("Enter price: ");
        double price = sc.nextDouble();

        // Đây là đối tượng được tạo mới thông qua constructor, dữ liệu lấy từ bàn phím
        day5.baitap3trang56.music.CompactDisc compactDisc = new day5.baitap3trang56.music.CompactDisc(title, artist, price, code);
        compactDisc.index = nextMusic;
        cd[nextMusic++] = compactDisc;
        System.out.println("Add music successfully");
    }

}
