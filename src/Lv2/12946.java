package Lv2;

import java.util.*;

class Sol_12946 {
    public static ArrayList<int[]> list = new ArrayList<>();

    public static int[][] solution(int n) {
        hanoii(1, 2, 3, n);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void hanoii(int from, int by, int to, int n) {
        if (n == 0) return;

        hanoii(from, to, by, n - 1); // n - 1 개 원판 from -> by
        list.add(new int[]{from, to}); // 제일 큰 원판 from -> to
        hanoii(by, from, to, n - 1); // n - 1 개 원판 by -> to
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(solution(n));
    }

}
