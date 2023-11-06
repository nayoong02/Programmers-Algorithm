package Lv2;

import java.util.*;

class Sol_49189 {
    public static int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        // 그래프 초기화
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 연결
        for (int[] e : edge) {
            int a = e[0];
            int b = e[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        int[] distances = new int[n + 1]; // 1과의 거리 차이 저장할 배열
        Arrays.fill(distances, -1); // -1로 초기화

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // 시작 노드
        distances[1] = 0; // 시작 노드까지의 거리는 0

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph[node]) {
                if (distances[neighbor] == -1) {
                    distances[neighbor] = distances[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        // 최댓값 카운트
        int maxDistance = 0;
        int count = 0;
        for (int distance : distances) {
            if (distance > maxDistance) {
                maxDistance = distance;
                count = 1;
            } else if (distance == maxDistance) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {2, 5}};
        System.out.println(solution(n, vertex));
    }
}
