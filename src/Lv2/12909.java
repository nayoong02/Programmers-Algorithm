package Lv2;

import java.util.*;

class Sol_12909 {
    static boolean solution(String s) {

        // 미리 걸러내기
        if (s.charAt(0) == ')' || s.charAt(s.length() - 1) == '(') {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') { // 여는 괄호면 무조건 스택에 push
                stack.push(s.charAt(i));
                continue;
            }
            if (!stack.isEmpty() && s.charAt(i) == ')') { // 닫는 괄호이고 스택에서 pop 할 게 있으면 pop
                stack.pop();
            } else { // pop 할 게 없으면 false 리턴
                return false;
            }

        }

        // 스택이 비어있어야 true
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "()()";
        System.out.println(solution(s));
    }

}
