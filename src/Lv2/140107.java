package Lv2;

import java.util.*;

class Sol_140107 {
    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            long xx = (long) x * x;
            long dd = (long) d * d;

            int y = (int) Math.sqrt(dd - xx); // 가능한 최대 y
            answer += (int)(y / k) + 1; // y까지 가는 좌표 수 카운트
        }

        return answer;
    }
}

