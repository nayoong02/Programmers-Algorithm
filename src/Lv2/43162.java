package Lv2;

class Sol_43162 {
    static int count, answer = 0; // 네트워크 개수
    static boolean[] visited; // 컴퓨터 방문 배열

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) { // 모든 컴퓨터 살펴보며 방문 전이면 dfs 호출
            if (!visited[i]) {
                dfs(n, i, visited, computers);
                count++;
            }
        }

        answer = count;
        return answer;
    }

    static void dfs(int n, int idx, boolean[] visited, int[][] computers) {
        visited[idx] = true; // 방문 처리

        for (int j = 0; j < n; j++) { // 연결돼있고 & 방문 전 & 자기 자신이 아니면
            if ((computers[idx][j] == 1) && (!visited[j]) && (idx != j)) {
                dfs(n, j, visited, computers);
            }
        }

    }

    public static void main(String[] args) {
        int n = 3;
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(n, computers));
    }

}