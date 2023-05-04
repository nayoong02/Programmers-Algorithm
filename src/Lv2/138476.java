package Lv2;

import java.util.*;

class Sol_138476 {
    public static int solution(int k, int[] tangerine) {
        Arrays.sort(tangerine);
        ArrayList<Integer> list = new ArrayList<>(); //원소 개수 담을 배열
        int count = 0;

        for(int i = 0; i < tangerine.length; i++) {
            count++;
           if((i < tangerine.length - 1) && (tangerine[i + 1] != tangerine[i])) {
               list.add(count);
               count = 0;
           } else if (i == tangerine.length - 1) {
               list.add(count);
               count = 0;
           }
        }

        Collections.sort(list, Collections.reverseOrder()); //원소 개수 배열 내림차순
        int answer = 0;
        int a = 0;

        for(int j : list) {
            answer++;
            a += j;

            if(a >= k) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        int k = 4;
        System.out.println(solution(k, tangerine));
    }

}

