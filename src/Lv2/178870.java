package Lv2;

import java.util.*;

class Sol_178870 {
    public static int[] solution(int[] sequence, int k) {
        ArrayList<int[]> list = new ArrayList<>();

        int start = 0;
        int end = 0;
        int sum = 0;

        while(true) {
            if (sum >= k) {
                sum -= sequence[start++];
            }
            else if (end >= sequence.length) { // 탈출 조건
                break;
            }
            else {
                sum += sequence[end++];
            }

            if (sum == k) { // 리스트에 시작, 끝 인덱스 같이 저장
                list.add(new int[]{start, end - 1});
            }
        }

        // 인덱스 차이로 오름치순 정렬, 차이 같으면 시작 인덱스 기준 오름차순 정렬
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] i1, int[] i2) {
                int len1 = i1[1] - i1[0];
                int len2 = i2[1] - i2[0];

                return len1 == len2 ? i1[0] - i2[0] : len1 - len2;
            }
        });

        return list.get(0);
    }

    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        System.out.println(solution(sequence, k));
    }

}
