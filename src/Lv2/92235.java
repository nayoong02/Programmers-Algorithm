package Lv2;

import java.util.*;

class Sol_92235 {
    static int answer = 0;
    static StringBuffer sb = new StringBuffer();
    static String changed = ""; // 진수 변환한 문자열

    public static int solution(int n, int k) {
        jinsu(n, k);
        isPrime(changed);

        return answer;
    }

    // 진수 변환
    public static void jinsu(int n, int k) {
        int rest = 0; // 나머지

        while (n > 0) { // 몫이 0보다 클 때 계속 반복
            rest = n % k; // 나머지
            n = n / k; // 몫

            sb.append(rest); // 나머지 문자열에 추가
        }
        changed = sb.reverse().toString(); // 나머지 순서대로 추가해놓은 것 반대로
    }

    // 조건에 맞는 소수 개수 구하기
    public static void isPrime(String changed) {
        String s = "";

        for (int i = 0; i < changed.length(); i++) {
            char c = changed.charAt(i);
            if (c == '0') {
                if (s != "") { // s가 빈 문자열이 아니면 (P0 체크)
                    if (isPrime2(Long.parseLong(s))) answer++;
                    s = "";
                }
            }
            else { // 0이 아닌 숫자면 문자열에 저장
                s += c;
            }
        }

        // 문자열이 남아있을 때 (0P) 체크
        if (s != "") {
            if (isPrime2(Long.parseLong(s))) answer++;
        }
    }

    // 값이 소수인지 체크하기
    public static boolean isPrime2(long num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 110011;
        int k = 10;
        System.out.println(solution(n, k));
    }
}
