package Lv3;

import java.util.*;

class Sol_87694 {
    static int answer = Integer.MAX_VALUE;
    // 좌표계 2배로 확대 필요 !!
    static int[][] matrix = new int[102][102];
    static boolean[][] visited = new boolean[102][102];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 사각형 테두리 채우기
        fillRectangle(rectangle);

        // 최단거리 구하기
        bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2);

        return answer;
    }

    public static void fillRectangle(int[][] rectangle) {
        for (int i = 0; i < rectangle.length; i++) {
            int bottomX = rectangle[i][1] * 2; // 열
            int bottomY = rectangle[i][0] * 2; // 행
            int topX = rectangle[i][3] * 2;
            int topY = rectangle[i][2] * 2;

            for (int s = bottomX; s <= topX; s++) {
                for (int e = bottomY; e <= topY; e++) {
                    if (s == bottomX || s == topX || e == bottomY || e == topY) {
                        if (matrix[s][e] == 2) { // 테두리인데 다른 사각형의 내부에 포함되면
                            continue;
                        }
                        matrix[s][e] = 1; // 테두리는 1로 설정
                    } else {
                        matrix[s][e] = 2; // 내부는 2로 설정
                    }
                }
            }
        }
    }

    public static void bfs(int characterX, int characterY, int itemX, int itemY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{characterY, characterX, 0});
        visited[characterY][characterX] = true;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tx = temp[0];
            int ty = temp[1];
            int tc = temp[2]; // 카운트

            if (tx == itemY && ty == itemX) {
                answer = Math.min(answer, tc / 2); // 처음에 2배로 늘려놨으니까
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                // 범위 안 && 방문 전
                if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix.length && matrix[nx][ny] == 1 && !visited[nx][ny]) {
                    queue.add(new int[]{nx, ny, tc + 1});
                    visited[nx][ny] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] rectangle = {{1,1,7,4}, {3,2,5,5}, {4,3,6,9}, {2,6,8,8}};
        int characterX = 1;
        int characterY = 3;
        int itemX = 7;
        int itemY = 8;
        System.out.println(solution(rectangle, characterX, characterY, itemX, itemY));
    }
}
