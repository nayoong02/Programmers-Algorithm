package Lv2;

import java.util.*;

class Sol_131704 {
    public static int solution(int[] order) {
        Stack<Integer> stack = new Stack<>(); // 보조 컨테이너
        int n = order.length; // 전체 상자 개수
        int idx = 0; // 타겟 상자 인덱스
        int answer = 0; // 실리는 상자 개수

        for (int i = 1; i <= n; i++) {
            boolean flag = false;

            if (i == order[idx]) { // 타겟 상자와 같다면
                idx++;
                answer++;
                flag = true;
            }

            while (!stack.isEmpty() && stack.peek() == order[idx]) { // 스택이 비어있지 않고, 맨 위 원소가 타겟 상자와 같다면 스택에서 pop
                stack.pop();
                idx++;
                answer++;
                flag = true;
            }

            if (flag == false) { // 위 두 경우 모두 아니면 바로 스택에 push
                stack.push(i);
            }
        }

        // 남은 상자들은 빼주기
        while (!stack.isEmpty() && stack.peek() == order[idx]) {
            stack.pop();
            idx++;
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] order = {5, 4, 3, 2, 1};
        System.out.println(solution(order));
    }

}
