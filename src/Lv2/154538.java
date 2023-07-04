package Lv2;

import java.util.*;

class Sol_154538 {
    static int answer = 0;

    public static int solution(int x, int y, int n) {

        return bfs(x, y, n);
    }

    public static int bfs(int x, int y, int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> set =  new HashSet<>();

        queue.add(x);
        set.add(x);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();

                if (tmp == y) return answer;
                if (tmp + n <= y && !set.contains(tmp + n)) {
                    queue.add(tmp + n);
                    set.add(tmp + n);
                }
                if (tmp * 2 <= y && !set.contains(tmp * 2)) {
                    queue.add(tmp * 2);
                    set.add(tmp * 2);
                }
                if (tmp * 3 <= y && !set.contains(tmp * 3)) {
                    queue.add(tmp * 3);
                    set.add(tmp * 3);
                }
            }

            answer++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 2;
        System.out.println(solution(x, y, n));
    }

}
