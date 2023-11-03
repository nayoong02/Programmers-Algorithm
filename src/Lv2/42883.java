package Lv2;

import java.util.*;

class Sol_42883 {
    public String solution(String number, int k) {
        int len = number.length();
        String answer = "";
        int delCount = 0; // 지운 개수

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            int curr = number.charAt(i) - '0'; //현재 숫자

            // 스택이 비어있지 x && 맨위 원소보다 현재 숫자가 더 클때 && 제거할 숫자가 더 남았을 때
            while(!stack.isEmpty() && stack.peek() < curr && delCount < k) {
                stack.pop();
                delCount++;
            }

            if (stack.size() < len - k) stack.push(curr); // 아직 길이만큼 안 찼으면
        }

        Iterator itr = stack.iterator();
        while(itr.hasNext()) {
            answer += itr.next();
        }

        return answer;
    }
}
