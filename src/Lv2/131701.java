package Lv2;

import java.util.*;

class Sol_131701 {
    public static int solution(int[] elements) {
        int len = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len; j++) {
                int sum = 0;
                for (int k = 0; k <= i - 1; k++) {
                    if (j + k > len - 1) { // 수열 범위 벗어나면 -> 처음부터 또 탐색
                        sum += elements[j + k - len];
                    }
                    else {
                        sum += elements[j + k];
                    }
                }

                set.add(sum);
            }
        }

        int answer = set.size();
        return answer;
    }

    public static void main(String[] args) {
        int[] elements = {7,9,1,1,4};
        System.out.println(solution(elements));
    }

}
