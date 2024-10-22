package day7.collections.list.comparator;

import java.util.Comparator;

public class AccountComparator implements Comparator<Account2> {

    @Override
    public int compare(Account2 o1, Account2 o2) {
        // so sánh tăng dần
       int result = o1.getAccountBalance() - o2.getAccountBalance();
       // So sánh nhanh, thay thế > <
        // nếu < -1 xếp trước
        // nếu > 1 xếp sau
       if(result == 0) {
            // compare trường khác
       }
       return result;
        // return 0, mình có thể so sánh đến các điều kiện khác
    }
}
