package Lv2;

import java.util.*;

class Sol_86971 {
    public static int[][] graph;

    public static int solution(int n, int[][] wires) {

        graph = new int[n + 1][n + 1];
        int answer = Integer.MAX_VALUE;

        // 전선 연결
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        // 전선 연결 하나씩 끊어가면서 카운트 비교
        for (int i = 0; i < wires.length; i++) {
            int from = wires[i][0];
            int to = wires[i][1];

            // 전선 연결 끊기
            graph[from][to] = 0;
            graph[to][from] = 0;

            // 차이 갱신
            answer = Math.min(bfs(n, from), answer);

            // 다시 전선 연결해주기
            graph[from][to] = 1;
            graph[to][from] = 1;
        }

        return answer;
    }

    public static int bfs(int n, int from) {
        boolean[] visited = new boolean[n + 1];
        visited[from] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(from);

        int count = 1;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int i = 1; i <= n; i++) {
                if (graph[temp][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }

        return Math.abs(count - (n - count));
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] wires = {{1,2}, {2,7}, {3,7}, {3,4}, {4,5}, {6,7}};

        System.out.println(solution(n, wires));
    }
}
