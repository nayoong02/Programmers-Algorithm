package Lv2;

import java.util.*;

class Sol_12953 {
    public static int solution(int[] arr) {
        Arrays.sort(arr);
        int answer = arr[0];

        for (int i = 1; i < arr.length; i++) {
            answer = lcm(answer, arr[i]);
        }

        return answer;
    }

    // 최대공약수
    public static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    // 최소공배수
    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void main(String[] args) {
        int[] arr = {14, 2, 7};
        System.out.println(solution(arr));
    }
}
