package Lv2;

import java.util.*;

class Sol_154539 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>(); // number 인덱스 담을 스택
        stack.push(0); // 인덱스 0 스택에 push

        for (int i = 1; i < numbers.length; i++) {
            int tmp = numbers[i]; // 현재 numbers 배열의 숫자

            while(!stack.isEmpty() && numbers[stack.peek()] < tmp) { // 스택이 비어있지 않고, 현재 스택의 수 보다 tmp 가 더 크면 뒤에 있는 큰 수이므로
                answer[stack.pop()] = tmp; // answer 배열에 저장
            }

            stack.push(i); // 현재 인덱스 push
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        System.out.println(solution(numbers));
    }

}
