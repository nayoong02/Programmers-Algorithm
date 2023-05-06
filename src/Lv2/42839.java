package Lv2;

import java.util.*;

class Sol_42839 {
    static HashSet<Integer> set = new HashSet<>();
    static int answer;
    static int len;
    static int num;
    static char[] arr;
    static boolean[] visited;

    public int solution(String numbers) {
        answer = 0; // 소수 개수
        len = numbers.length();

        arr = new char[len];
        visited = new boolean[len];

        // char 배열에 numbers 넣기
        for (int i = 0; i < len; i++) {
            arr[i] = numbers.charAt(i);
        }

        combination("", 0);

        answer = set.size();
        return answer;
    }

    static void combination(String str, int idx) {
        if (str != "") { // 탈출조건 -> 검증 진행
            num = Integer.parseInt(str);
            if (isPrime(num)) { // 소수 조건 만족하면 set에 add
                set.add(num);
            }
        }

        if (idx == len) return;

        else { // 백트래킹 진행
            for (int i = 0; i < len; i++) {
                if (visited[i]) continue; // 이미 방문했으므로 넘어가
                visited[i] = true;
                combination(str + arr[i], idx + 1);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    static boolean isPrime(int num) {
        if (num == 1 || num == 0) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}

