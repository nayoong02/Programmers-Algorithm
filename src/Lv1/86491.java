package Lv1;

import java.util.*;

class Sol_86491 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxw = 0;
        int maxh = 0;

        for (int[] size : sizes) {
            maxw = Math.max(maxw, Math.max(size[0], size[1]));
            maxh = Math.max(maxh, Math.min(size[0], size[1]));
        }

        answer = maxw * maxh;
        return answer;
    }
}