package Lv2;

import java.util.*;

class Sol_155651 {
    public static int solution(String[][] book_time) {
        int[][] time = new int[book_time.length][2]; // book_time -> 2차원 정수형 배열로

        for (int i = 0; i < book_time.length; i++) {
            int startTime = Integer.parseInt(book_time[i][0].replace(":", "")); // 대실 시각
            int endTime =  Integer.parseInt(book_time[i][1].replace(":", "")); // 퇴실 시각

            endTime += 10; // 청소시간 더해주기
            if (endTime % 100 >= 60) { // 정각 넘어가는 부분 처리
                endTime += 40;
            }

            time[i][0] = startTime;
            time[i][1] = endTime;
        }

        // 대실 시각 -> 퇴실 시각 기준 오름차각
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
            }
        });

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 대실 가능 시각 저장할 우선순위 큐
        for (int[] t : time) {
            if (queue.isEmpty()) {
                queue.offer(t[1]);
                continue;
            }
            if (queue.peek() > t[0]) {
                queue.offer(t[1]);
            }
            else {
                queue.poll();
                queue.offer(t[1]);
            }
        }

        return queue.size();
    }

    public static void main(String[] args) {
        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(book_time));
    }

}
