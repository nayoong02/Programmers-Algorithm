package Lv1;

import java.util.*;

class Sol_12906 {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];

            if (i == 0) { // 첫번째 원소는 바로 넣기
                stack.push(temp);
            }
            while(!stack.isEmpty()) {
                if (stack.peek() == temp) break;
                else {
                    stack.push(temp);
                }
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            answer[i] = stack.get(i);
        }

        return answer;
    }
}
