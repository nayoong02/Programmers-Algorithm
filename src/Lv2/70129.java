package Lv2;

import java.util.*;

class Sol_70129 {
    public static int[] solution(String s) {
        int round = 0; // 회차
        int count = 0; // 0 개수

        while (!s.equals("1")) {
            int len = s.length(); // 원래 문자열 길이
            s = s.replace("0", ""); // 0 제거
            int len2 = s.length(); // 0 제거 후 문자열 길이
            count += (len - len2); // 제거한 0 카운트

            s = binary(len2); // 이진수로
            round++; // 회차 증가
        }

        int[] answer = new int[2];
        answer[0] = round;
        answer[1] = count;

        return answer;
    }

    public static String binary(int len2) {
        StringBuilder sb = new StringBuilder();

        while (len2 > 0) {
            int remain = len2 % 2; // 나머지
            sb.insert(0, remain); // 나머지를 앞에서부터 추가
            len2 /= 2;
        }

        return sb.toString(); // 문자열 리턴
    }

    public static void main(String[] args) {
        String s = "110010101001";
        System.out.println(solution(s));
    }
}
