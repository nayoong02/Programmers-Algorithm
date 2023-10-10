package Lv3;

import java.util.*;

class Sol_42627 {
    public static int solution(int[][] jobs) {

        // 시작 시각 기준 오름차순 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 소요 시간 기준으로 오름차순 정렬
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int jobCount = 0; // 작업 카운트
        int idx = 0; // 작업 목록 인덱스
        int end = 0; // 작업 끝난 시각
        int answer = 0; // 시간 총합

        while (jobCount < jobs.length) {
            // 작업 끝난 시점 전까지 요청 들어와있는 작업들을 큐에 넣기
            while (idx < jobs.length && jobs[idx][0] <= end) {
                queue.add(jobs[idx++]);
            }

            if (!queue.isEmpty()) { // 큐 안에 있는 대기 작업들 모두 수행
                int[] now = queue.poll();
                answer += (end + now[1] - now[0]);
                end += now[1];
                jobCount++;
            } else { // 큐가 비었으면 (대기 목록에 작업 x) -> 다음 작업 시작점을 현재 시간으로 업데이트
                end = jobs[idx][0];
            }
        }

        answer = (int) Math.floor(answer / jobs.length);
        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {4, 9}, {5, 6}};
        System.out.println(solution(jobs));
    }
}
