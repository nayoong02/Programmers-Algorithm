package Lv1;

import java.util.*;

class Sol_42748 {
    public static int[] solution(int[] array, int[][] commands) {
        int com_size = commands.length;
        int i, j, k;
        ArrayList<Integer> list = new ArrayList<>(); // 정렬할 원소 담을 리스트
        int[] answer = new int[com_size]; // 정답 담을 배열

        for (int l = 0; l < com_size; l++) {
            list.clear();
            i = commands[l][0];
            j = commands[l][1];
            k = commands[l][2];

            for (int m = i - 1; m <= j - 1; m++) { // 정렬할 원소 리스트에 담기 (i-1 ~ j-1 인덱스)
                list.add(array[m]);
            }

            Collections.sort(list); // 오름차순 정렬
            answer[l] = list.get(k - 1); // 정렬된 리스트에서 k-1 번째 원소 정답 배열에 담기
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        System.out.println(solution(array, commands));
    }

}
