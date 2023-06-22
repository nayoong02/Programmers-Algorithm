package Lv2;

import java.util.*;

//class Sol_42577 {
//    public static boolean solution(String[] phone_book) {
//        int len = phone_book.length;
//        HashSet<String> set = new HashSet<>();
//
//        for (int i = 0; i < len; i++) {
//            set.add(phone_book[i]);
//        }
//
//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < phone_book[i].length(); j++) {
//                if (set.contains(phone_book[i].substring(0, j))) return false;
//            }
//        }
//
//        return true;
//    }
//
//    public static void main(String[] args) {
//        String[] nums = {"119", "97674223", "1195524421"};
//        System.out.println(solution(nums));
//    }
//
//}


class Sol_42577 {
    public static boolean solution(String[] phone_book) {
        int len = phone_book.length;
        boolean answer = true;
        Arrays.sort(phone_book);

        for (int i = 0; i < len - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                answer = false;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] nums = {"119", "97674223", "1195524421"};
        System.out.println(solution(nums));
    }

}
