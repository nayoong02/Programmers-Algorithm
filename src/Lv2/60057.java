package Lv2;

import java.util.*;

class Sol_60057 {
    public static int solution(String s) {
        int min = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            String newWord = compress(i, s);
            // 최소 길이 갱신
            min = Math.min(min, newWord.length());
        }

        return min;
    }

    // 문자열 압축
    public static String compress(int num, String s) {
        String pattern = s.substring(0, num); // num만큼 앞에서부터 단어 자르기
        int count = 1;
        StringBuilder sb = new StringBuilder();

        for (int i = num; i + num <= s.length() || i < s.length(); i += num) {
            // 마지막 남은 문자열이 num보다 짧은 경우도 처리해야하므로 !!!
            String ss = i + num <= s.length() ? s.substring(i, i + num) : s.substring(i);

            if (ss.equals(pattern)) { // 반복되면 카운트만 증가
                count++;
            } else { // 다르면
                if (count > 1) { // 카운트 출력
                    sb.append(count);
                }
                sb.append(pattern); // 반복 단어 출력

                pattern = ss; // 반복 기준 단어 갱신
                count = 1; // 카운트 초기화
            }
        }

        // 남아있는 문자열 처리
        if (count > 1) {
            sb.append(count);
        }
        sb.append(pattern);

        return String.valueOf(sb);
    }

    public static void main(String[] args) {
        String s = "aabbaccc";
        System.out.println(solution(s));
    }
}
