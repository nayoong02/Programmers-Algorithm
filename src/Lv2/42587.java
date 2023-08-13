package Lv2;

import java.util.*;

class Sol_42587 {
    public static int solution(int[] priorities, int location) {

        PriorityQueue<Process> pqueue = new PriorityQueue<>(); // 가장 높은 우선 순위 판별 위한 우선순위큐
        Queue<Process> queue = new LinkedList<>(); // 실제로 프로세스 제거/추가 진행할 큐

        char[] loc_arr = new char[priorities.length]; // 프로세스 원소 담을 배열 (A, B, C,,,)
        for (int i = 0; i < loc_arr.length; i++) {
            loc_arr[i] = (char)(65 + i);
        }

        for (int i = 0; i < priorities.length; i++) { // 큐에 add
            pqueue.offer(new Process(loc_arr[i], priorities[i]));
            queue.offer(new Process(loc_arr[i], priorities[i]));
        }

        int count = 0;
        while(!queue.isEmpty()) {
            int max = pqueue.peek().prior; // 현재 큐에 존재하는 프로세스 중 가장 높은 우선순위
            Process first = queue.peek(); // 큐에서 꺼낸 맨 앞 프로세스

            if (first.prior < max) { // 더 높은 우선순위 존재하면 다시 큐에 추가
                queue.remove(first);
                queue.offer(first);
                continue;
            }
            else {
                count++;
                if (first.el == loc_arr[location]) { // 해당 프로세스이면 반복문 종료
                    break;
                }
                queue.remove(first); // 아니면 큐에서 제거 후 계속 진행
                pqueue.poll();
            }
        }

        return count;
    }

    static class Process implements Comparable<Process> { // 우선순위큐에 넣기 위해 Comparable 클래스 구현
        private char el; // 프로세스 원소
        private int prior; // 프로세스 우선순위

        Process(char el, int prior) {
            this.el = el;
            this.prior = prior;
        }

        @Override
        public int compareTo(Process p) { // 우선순위 높은것부터 정렬 (내림차순)
            return p.prior - this.prior;
        }
    }

    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        System.out.println(solution(priorities, location));
    }

}
