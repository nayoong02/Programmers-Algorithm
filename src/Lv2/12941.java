package Lv2;

import java.util.*;

class Sol_12941 {
    public int solution(int[] A, int[] B) {
        int answer = 0;

        PriorityQueue<Integer> a = new PriorityQueue<>(); // 오름차순 정렬
        PriorityQueue<Integer> b = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬

        // 큐에 넣기
        for (int i = 0; i < A.length; i++) {
            a.add(A[i]);
            b.add(B[i]);
        }

        // 각 a, b에서 원소 하나씩 뽑아서 곱하기
        while (!a.isEmpty()) {
            answer += a.poll() * b.poll();
        }

        return answer;
    }
}
