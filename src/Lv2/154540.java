package Lv2;

import java.util.*;

class Sol_154540 {
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static int[] solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        ArrayList<Integer> list = new ArrayList<>();

        // 지도 채워넣기
        for (int i = 0; i < maps.length; i++) {
            map[i] = maps[i].toCharArray();
        }

        // bfs 호출
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j));
                }
            }
        }

        // 오름차순 정렬
        if (list.size() == 0) {
            list.add(-1);
        } else {
            Collections.sort(list);
        }

        // list 를 array 로
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int bfs(int i, int j) {
        int sum = 0;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{i, j});
        visited[i][j] = true;

        while(!queue.isEmpty()) {
            int[] c = queue.poll();
            int cx = c[0];
            int cy = c[1];
            sum += map[cx][cy] - '0';

            for (int k = 0; k < 4; k++) {
                int ncx = cx + dx[k];
                int ncy = cy + dy[k];

                if (ncx >= 0 && ncy >= 0 && ncx < map.length && ncy < map[0].length) {
                    if (!visited[ncx][ncy] && map[ncx][ncy] != 'X') {
                        visited[ncx][ncy] = true;
                        queue.offer(new int[]{ncx, ncy});
                    }
                }
            }
        }
        return sum;
    }

}
