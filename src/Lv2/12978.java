package Lv2;

import java.util.*;

class Sol_12978 {
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[][] matrix = new int[N + 1][N + 1];

        // 행렬 초기화
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    continue;
                } else { // 최대값으로 넣어놓기
                    matrix[i][j] = 500000;
                    matrix[j][i] = 500000;
                }
            }
        }

        // 간선 연결
        for (int i = 1; i <= road.length; i++) {
            int s = road[i - 1][0]; // 시작점
            int e = road[i - 1][1]; // 도착점
            int w = road[i - 1][2]; // 가중치

            matrix[s][e] = Math.min(matrix[s][e], w);
            matrix[e][s] = Math.min(matrix[e][s], w);
        }

        floyd(matrix, N);

        // K 이하인 정점 세기
        for (int j = 1; j <= N; j++) {
            if (matrix[1][j] <= K) {
                answer++;
            }
        }
        return answer;
    }

    // 플로이드-워샬 알고리즘
    static void floyd(int[][] matrix, int n) {
        // 경유지
        for (int k = 1; k <= n; k++) {
            // 시작점
            for (int i = 1; i <= n; i++) {
                // 도착점
                for (int j = 1; j <= n; j++) {
                    if (i == j) continue;
                    // 최단거리 갱신
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }
    }

    public static void main(String[] args) {
        int N = 5;
        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int K = 3;
        System.out.println(solution(N, road, K));
    }
}
