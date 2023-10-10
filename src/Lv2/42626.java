package Lv2;

import java.util.*;

class Sol_42626 {
    public static int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 오름차순 정렬 우선순위큐

        // 큐에 스코빌 지수 집어넣기
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        int count = 0;

        while(queue.peek() < K) { // 맨 첫 원소가 K보다 작은 경우 계속 반복
            if (queue.size() == 1) { // 큐에 하나밖에 안남았는데 K보다 작을 때
                return -1;
            }
            else {
                int first = queue.poll();
                int sec = queue.poll();
                int third = first + (sec * 2);
                queue.add(third);
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(solution(scoville, K));
    }
}
