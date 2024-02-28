package Lv2;

import java.util.*;

class Sol_148653 {
    static int answer = Integer.MAX_VALUE;
    static int[] cnt = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1};

    public static int solution(int storey) {

        bfs(storey, 0);
        return answer;
    }

    static void bfs(int curr, int val) {
        if (curr < 10) {
            int p = curr > 5 ? 1 : 0;
            answer = Math.min(cnt[curr] + p + val, answer);
            return;
        }
        if (curr % 10 <= 5) {
            bfs(curr / 10, cnt[curr % 10] + val);
        }
        if (curr % 10 >= 5) {
            bfs(curr / 10 + 1, cnt[curr % 10] + val);
        }
    }

    public static void main(String[] args) {
        int storey = 95;
        System.out.println(solution(storey));
    }
}
