package Lv2;

import java.util.*;

class Sol_1844 {
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int[] dy = {0, 1, 0, -1};
    static int n, m = 0;
    static int answer = Integer.MAX_VALUE;;

    public static int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];

        bfs(0, 0, maps);
        return (answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void bfs(int i, int j, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {i, j, 1});
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int cx = temp[0];
            int cy = temp[1];
            int count = temp[2];

            // 최단거리 갱신
            if (cx == n - 1 && cy == m - 1) {
                answer = Math.min(count, answer);
            }

            // 4방향
            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d]; // 다음 위치
                int ny = cy + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) { // 범위 안
                    if (!visited[nx][ny] && maps[nx][ny] == 1) { // 방문 전이고 벽이 아니면
                        visited[nx][ny] = true;
                        queue.add(new int[] {nx, ny, count + 1});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}};
        System.out.println(solution(maps));
    }
}
