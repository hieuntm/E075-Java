package day10.baitap.bai6trang89;

import java.util.TreeMap;

public class BookManager<K, V> {

    private final TreeMap<K, V> BookTreeMap;

    public BookManager() {
        BookTreeMap = new TreeMap<>();
    }

    public void addNewBook(V object){
        if(object instanceof Book){ // Phải là object Book
            Book book = (Book) object;
            BookTreeMap.put((K) book.getBookId(), object);
        }
    }
}
