package Lv3;

import java.util.*;

class Sol_43238 {
    public static long solution(int n, int[] times) {
        Arrays.sort(times); // 오름차순 정렬

        long answer = 0;
        long min = 1; // 최소 시간
        long max = (long) times[times.length - 1] * n; // 최대 시간

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0; // 심사 가능한 사람 수

            for (int t : times) {
                count += mid / t;

                if (count >= n) break;
            }

            if (count >= n) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = 6;
        int[] times = {7, 10};
        System.out.println(solution(n, times));
    }
}
