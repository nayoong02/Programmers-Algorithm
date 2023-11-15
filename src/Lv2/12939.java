package Lv2;

import java.util.*;

class Sol_12939 {
    public String solution(String s) {
        String answer = "";
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(s);
        while (st.hasMoreTokens()) {
            String tk = st.nextToken();
            list.add(Integer.parseInt(tk));
        }

        Collections.sort(list);
        answer += list.get(0) + " " + list.get(list.size() - 1);
        return answer;
    }
}
