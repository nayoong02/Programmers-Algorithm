package Lv2;

import java.util.*;

class Sol_42578 {
    public static int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = clothes.length;

        for (int i = 0; i < len; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }

        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "headgear"}, {"green_turban", "headgear"}};
        System.out.println(solution(clothes));
    }

}
