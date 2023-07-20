package Lv2;

import java.util.*;

class Sol_132265 {
    public static int solution(int[] topping) {
        Map<Integer, Integer> map = new HashMap<>(); // 토핑 종류, 개수
        Set<Integer> set = new HashSet<>(); // 토핑 종류 저장할 set
        int answer = 0;

        for (int t : topping) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            set.add(t);
            map.put(t, map.get(t) - 1); // 토핑 개수 빼주기

            if (map.get(t) == 0) { // 개수 0 되면 map 에서 remove
                map.remove(t);
            }

            if (set.size() == map.size()) { // set, map 사이즈 같아지면 answer++
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(topping));
    }

}
