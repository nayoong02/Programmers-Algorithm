package Lv2;

class Sol_87946 {
    static int num, answer = 0;
    static boolean[] visited;
    public static int solution(int k, int[][] dungeons) {
        num = dungeons.length;
        visited = new boolean[num];

        dfs(0, k, dungeons);

        return answer;
    }

    static void dfs(int count, int k, int[][] dungeons) {
        for (int i = 0; i < num; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(count + 1, k - dungeons[i][1], dungeons);
                visited[i] = false;
            }
        }
        answer = Math.max(count, answer);
    }

    public static void main(String[] args) {
        int k = 10;
        int[][] dungeons = {{9, 2}, {10, 3}, {7, 3}, {5, 4}, {1, 1}};
        System.out.println(solution(k, dungeons));
    }

}
