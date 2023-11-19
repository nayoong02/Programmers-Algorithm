package Lv2;

import java.util.*;

class Sol_64065 {
    public static int[] solution(String s) {
        String[] split = s.split("},\\{"); // "{{2 / 2,1 / 2,1,3 / 2,1,3,4}}"
        // 맨 앞, 맨 뒤 {{, }} 지우기
        split[0] = split[0].replace("{{", "");
        split[split.length - 1] = split[split.length - 1].replace("}}", ""); // "2 / 2,1 / 2,1,3 / 2,1,3,4"

        String[][] array = new String[split.length][]; // 묶음 담을 2차원 배열
        for (int i = 0; i < array.length; i++) {
            String[] word = split[i].split(",");
            int len = word.length; // 묶음 길이
            array[len - 1] = new String[len]; // array[len-1] 초기화 (null 에러 방지)

            for (int j = 0; j < len; j++) { // 길이가 인덱스가 되어 2차원 배열에 할당
                array[len - 1][j] = word[j];
            }
        }

        int[] answer = new int[split.length]; // 정답 배열
        HashSet<String> set = new HashSet<>();
        // set에 넣기
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (!set.contains(array[i][j])) {
                    set.add(array[i][j]);
                    answer[i] = Integer.parseInt(array[i][j]); // 배열에도 넣기
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "{{2,1},{2},{2,1,3},{2,1,3,4}}";
        System.out.println(solution(s));
    }
}
