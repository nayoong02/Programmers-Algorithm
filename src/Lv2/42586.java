package Lv2;

import java.util.*;

class Sol_42586 {
    public static int[] solution(int[] progresses, int[] speeds) {
        int num = progresses.length;
        int count = 0; // 기능 개수
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int days = (int)Math.ceil((100.0 - (double)progresses[i]) / (double)speeds[i]); // 배포까지 남은 날 (올림 처리)

            if (i == 0) { // 처음에는 바로 스택에 push 후 카운트
                stack.push(days);
                count++;
            }
            else {
                while(!stack.isEmpty()) {
                    if (days <= stack.peek()) { // 스택의 맨 위 원소보다 작거나 같으면 단순 기능 카운트
                        count++;
                    }
                    else { // 스택의 맨 위 원소보다 크면
                        list.add(count); // 현재 카운트 -> 리스트에 추가
                        count = 0; // 카운트 초기화
                        while(!stack.isEmpty()) { // 스택에 남아있는 days 모두 pop 후 원소 push
                            stack.pop();
                        }
                        stack.push(days);
                        count++;
                    }
                    break;
                }

            }
        }

        list.add(count); // 마지막 카운트 리스트에 추가

        // list -> answer 배열로 옮기기
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }


    public static void main(String[] args) {
        int[] progresses = {96, 94};
        int[] speeds = {3, 3};
        System.out.print(solution(progresses, speeds));
    }

}
