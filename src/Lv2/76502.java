package Lv2;

import java.util.*;

class Sol_76502 {
    public static int solution(String s) {
        int answer = 0;

        // 문자열 회전 후 check
        for (int i = 0; i < s.length(); i++) {
            String move = s.substring(0, i);
            String newString = s.substring(i);
            newString += move;

            if (check(newString)) answer++;
        }

        return answer;
    }

    // 올바른 괄호 문자열인지 check하는 함수
     static boolean check(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(' :
                    stack.push('(');
                    break;
                case '{' :
                    stack.push('{');
                    break;
                case '[' :
                    stack.push('[');
                    break;
                case ')' :
                    if (stack.isEmpty() || stack.peek() != '(') return false; // 스택이 비어있거나 맨 위 원소가 짝꿍 아닌 경우
                    stack.pop(); // 짝꿍인 경우
                    break;
                case '}' :
                    if (stack.isEmpty() || stack.peek() != '{') return false;
                    stack.pop();
                    break;
                case ']' :
                    if (stack.isEmpty() || stack.peek() != '[') return false;
                    stack.pop();
                    break;
            }
        }

         return stack.isEmpty(); // 최종 스택 비어있으면 true
    }

    public static void main(String[] args) {
        String s = "{{{}";
        System.out.print(solution(s));
    }

}
