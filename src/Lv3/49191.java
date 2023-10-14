package Lv3;

import java.util.*;

class Sol_49191 {
    public int solution(int n, int[][] results) {
        // 그래프 초기화
        int[][] graph = new int[n + 1][n + 1];

        // 간선 연결
        for (int[] arr : results) {
            int a = arr[0];
            int b = arr[1];

            graph[a][b] = 1; // 이긴 관계
            graph[b][a] = -1; // 진 관계
        }

        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // i > k, k > j -> i > j
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                        graph[j][i] = -1;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j] == 1 || graph[i][j] == -1) {
                    count++;
                }
            }
            if (count == n - 1) answer++; // 한 선수당 엮여있는 관계가 n-1개면 순위 확실하게 알 수 있음.
        }

        return answer;
    }
}
