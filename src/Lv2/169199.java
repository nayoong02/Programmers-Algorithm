package Lv2;

import java.util.LinkedList;
import java.util.Queue;

class Sol_169199 {
    public static int solution(String[] board) {
        int h = board.length;
        int w = board[0].length();

        String[][] map = new String[h][w];
        boolean[][] visited = new boolean[h][w];

        int[] dx = {-1, 0, 1, 0}; // 서, 남, 동, 북
        int[] dy = {0, 1, 0, -1};
        int[] start = new int[2];

        for (int i = 0; i < h; i++) {
            String tmp = board[i];

            for (int j = 0; j < tmp.length(); j++) {
                map[i][j] = tmp.split("")[j];

                if (map[i][j].equals("R")) { // 시작 위치
                    start[0] = i;
                    start[1] = j;
                }
            }
        }

        // BFS
        Queue<int[]> queue = new LinkedList<>(); // x좌표, y좌표, 이동횟수
        queue.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int y = q[0]; // 현재 인덱스
            int x = q[1];
            int cnt = q[2];

            // 이동
            for (int i = 0; i < 4; i++) {
                int nx = x;
                int ny = y;

                // 한 방향으로 멈출 때까지 이동 (보드를 넘어가거나, 장애물에 부딪히면 stop)
                while (true) {
                    if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                        break;
                    }

                    if (map[ny][nx].equals("D")) { // 장애물이면 멈추고 한칸 뒤로
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }

                    nx += dx[i];
                    ny += dy[i];
                }

                // 보드를 넘어갈 경우, 방향에 따라 위치 재조정
                if (ny < 0 || ny >= h || nx < 0 || nx >= w) {
                    if (i == 0) {
                        nx = 0;
                    } else if (i == 1) {
                        ny = h - 1;
                    } else if (i == 2) {
                        nx = w - 1;
                    } else {
                        ny = 0;
                    }
                }

                if (map[ny][nx].equals("G")) { // 목표 지점이면 카운트 증가 후 리턴
                    return cnt + 1;
                }

                if (!visited[ny][nx]) { // 아직 방문 전이면
                    queue.add(new int[]{ny, nx, cnt + 1});
                    visited[ny][nx] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String[] board = {".D.R", "....", ".G..", "...D"};
        System.out.println(solution(board));
    }
}
