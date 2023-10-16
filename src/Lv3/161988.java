package Lv3;

import java.util.*;

class Sol_161988 {
    public long solution(int[] sequence) {
        int len = sequence.length; // 배열 길이
        if (len == 1) return Math.abs(sequence[0]); // 길이가 1이면 바로 절댓값 리턴

        long[] minus = new long[len]; // -1, 1, -1, 1,,,
        long[] plus = new long[len]; // 1, -1, 1, -1,,,

        minus[0] = sequence[0] * -1;
        plus[0] = sequence[0];

        // 펄스 수열 곱한 값 dp 배열에 저장
        // i번째 자리에서 펄스 곱한 값, 그전 합 + 현재값 중 최대값 갱신
        for (int i = 1; i < sequence.length; i++) {
            if (i % 2 == 0) {
                minus[i] = Math.max(minus[i - 1] + sequence[i] * -1, sequence[i] * -1);
                plus[i] = Math.max(plus[i - 1] + sequence[i] * 1, sequence[i] * 1);
            } else {
                minus[i] = Math.max(minus[i - 1] + sequence[i] * 1, sequence[i] * 1);
                plus[i] = Math.max(plus[i - 1] + sequence[i] * -1, sequence[i] * -1);
            }
        }

        Arrays.sort(minus);
        Arrays.sort(plus);

        return Math.max(minus[len - 1], plus[len - 1]);
    }
}
