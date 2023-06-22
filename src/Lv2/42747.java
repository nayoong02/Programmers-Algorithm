package Lv2;

import java.util.*;

class Sol_42747 {
    public static int solution(int[] citations) {
        int n = citations.length;
        int answer = 0;

        Arrays.sort(citations); // 배열 오름차순 정렬

        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] citations = {1, 4, 5};
        System.out.println(solution(citations));
    }

}
