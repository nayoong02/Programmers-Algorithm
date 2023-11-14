package Lv3;

import java.util.*;

class Sol_43164 {
    static ArrayList<String> list = new ArrayList<>();
    static boolean[] visited;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        backtracking("ICN", 0, "ICN", tickets);
        Collections.sort(list);
        return list.get(0).split(" ");
    }

    public void backtracking(String s, int idx, String result, String[][] tickets) {
        if (idx == tickets.length) {
            list.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(s)) {
                visited[i] = true;
                backtracking(tickets[i][1], idx + 1, result + " " + tickets[i][1], tickets);

                visited[i] = false;
            }
        }
    }
}
