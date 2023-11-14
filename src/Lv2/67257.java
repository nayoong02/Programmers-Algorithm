package Lv2;

import java.util.ArrayList;

class Sol_67257 {
    static long ans;
    static char[] operators = {'*', '+', '-'};
    static boolean[] visited = new boolean[3];
    static char[] newOp = new char[3]; // 연산자 순열대로 저장할 새 배열

    public static long solution(String expression) {
        ArrayList<Long> n_list = new ArrayList<>(); // 숫자 담을 배열
        ArrayList<Character> op_list = new ArrayList<>(); // 연산자 담을 배열

        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (c >= '0' && c <= '9') { // 숫자면 일단 문자열에 저장
                num += c;
            } else { // 연산자면 앞에까지의 문자열 저장 후 연산자 따로 저장
                n_list.add(Long.parseLong(num));
                num = ""; // 문자열 초기화
                op_list.add(c);
            }
        }
        n_list.add(Long.parseLong(num)); // 남은 숫자 리스트에 추가

        permutation(n_list, op_list, 0);
        return ans;
    }

    // 연산자 순열 구하기
    public static void permutation(ArrayList<Long> n_list, ArrayList<Character> op_list, int depth) {
        if (depth == 3) { // 3개 채워지면
            long temp = calculate((ArrayList<Long>) n_list.clone(), (ArrayList<Character>) op_list.clone()); // 연산 시작
            if (temp > ans) ans = temp; // 최대값 갱신
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!visited[i]) {
                visited[i] = true;
                newOp[i] = operators[depth];
                permutation(n_list, op_list, depth + 1);
                visited[i] = false;
            }
        }
    }

    // 연산자 우선순위에 따라 연산
    public static long calculate(ArrayList<Long> n_list, ArrayList<Character> op_list) {
        for (char operator : newOp) { // 연산자 하나씩 추출
            int j = 0;
            while (j < op_list.size()) {
                if (operator == op_list.get(j)) { // 우선순위대로 추출한 연산자에 따라 연산 시작
                    switch (operator) {
                        case '*':
                            n_list.add(j, n_list.remove(j) * n_list.remove(j));
                            break;
                        case '+':
                            n_list.add(j, n_list.remove(j) + n_list.remove(j));
                            break;
                        case '-':
                            n_list.add(j, n_list.remove(j) - n_list.remove(j));
                            break;
                    }
                    op_list.remove(j); // 연산자 삭제
                } else {
                    j++;
                }
            }
        }
        return Math.abs(n_list.get(0)); // 절댓값 !!!
    }

    public static void main(String[] args) {
        String expression = "50*6-3*2";
        System.out.println(solution(expression));
    }
}
