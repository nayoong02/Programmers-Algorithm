package Lv2;

import java.util.*;

class Sol_181188 {
    public static int solution(int[][] targets) {

        // 2차원 배열 끝 기준 오름차순 정렬
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int count = 1;
        int end = targets[0][1];

        for (int i = 0; i < targets.length; i++) {
            int s = targets[i][0]; // 시작점
            int e = targets[i][1]; // 끝점

            if (s >= end) { // 시작점이 end 보다 같거나 크다면
                end = e; // end 값 갱신
                count++; // 카운트 증가
            }

        }

        return count;
    }

    public static void main(String[] args) {
        int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        System.out.println(solution(targets));
    }

}
