package Lv2;

import java.util.*;

class Sol_42746 {
    public static String solution(int[] numbers) {

        String answer = "";
        String[] array = new String[numbers.length];

        // 문자열 배열에 numbers 원소 넣기
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2); // 내림차순
            }
        });

        for (String s : array) {
            answer += s;
        }

        if (answer.startsWith("0")) { // 0...으로 시작하면 그냥 0으로
            answer = "0";
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0};
        System.out.println(solution(nums));
    }

}
