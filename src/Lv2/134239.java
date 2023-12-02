package Lv2;

import java.util.*;

class Sol_134239 {
    static int n; // 1로 만들기 위한 횟수
    static ArrayList<Integer> list = new ArrayList<>(); // 그래프 좌표 저장 (n + 1개)
    static ArrayList<Double> square = new ArrayList<>(); // 사다리꼴 넓이 저장 (n개)
    static double[] answer; // 정적분 담을 배열

    public static double[] solution(int k, int[][] ranges) {

        list.add(k);
        n = woobak(k);

        // 리스트에 n - 1개 사다리꼴 담기
        for (int i = 0; i < list.size() - 1; i++) {
            square.add((double)(list.get(i) + list.get(i + 1)) / 2);
        }

        answer = new double[ranges.length]; // 너비 담을 배열

        // 정적분 구하기
        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = ranges[i][1];

            answer[i] = calculate(start, end);
        }

        return answer;
    }

    // 1 될 때까지 반복
    public static int woobak(int k) {
        while (k > 1) {
            if (k % 2 == 0) { // 짝수이면 2로 나누고 카운트 증가
                k /= 2;
                n++;
            } else if (k % 2 == 1) { // 홀수이면 3을 곱하고 1 더하고 카운트 증가
                k = k * 3 + 1;
                n++;
            }
            list.add(k); // 좌표 저장
        }
        return n;
    }

    // 정적분 누적 합 구하기
    public static double calculate(int start, int end) {
        double area = 0; // 정적분 넓이 합
        int newEnd = 0; // 새로운 끝점 (연산처리된)

        if (end < 0) { // 음수면
            newEnd = n + end;
        } else { // 양수면
            newEnd = n - end;
        }

        if (start == newEnd) area = 0.0; // 같은점이면
        else if (start > newEnd) area = -1.0; // 시작점이 더 크면 무조건 -1
        else { // 각 사다리꼴 누적합
            for (int i = start; i < newEnd; i++) {
                area += square.get(i);
            }
        }

        return area;
    }

    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        System.out.println(solution(k, ranges));
    }
}
