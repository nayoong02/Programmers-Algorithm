package Lv2;

import java.util.*;

class Sol_42584 {
    public int[] solution(int[] prices) {

        Stack<Integer> stack = new Stack<>();
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            stack.push(prices[i]); // 비교대상 일단 스택에 넣기
            int cnt = 0;

            for (int j = i + 1; j < prices.length; j++) { // 비교대상 뒤부터 카운트
                if (stack.peek() <= prices[j]) { // 같거나 크면 카운트
                    cnt++;
                }
                else if (stack.peek() > prices[j]) { // 작아도 한 번 카운트 후 출력
                    cnt++;
                    answer[i] = cnt;
                    break;
                }
                if (j == prices.length - 1) { // 끝 인덱스까지 가면 카운트 출력
                    answer[i] = cnt;
                    break;
                }
            }

        }
        return answer;
    }
}
