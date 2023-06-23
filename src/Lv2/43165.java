package Lv2;

class Sol_43165 {
    static int answer = 0;

    public static int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    static void dfs(int[] numbers, int target, int idx, int sum) {
        if (idx == numbers.length) { // 문자열 개수 다 채웠는데
            if (sum == target) { // 합이 타겟과 같아졌을 때
                answer++;
            }
            return;
        }

        dfs(numbers, target, idx + 1, sum + numbers[idx]); // 더하기
        dfs(numbers, target, idx + 1, sum - numbers[idx]); // 빼기
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(solution(numbers, target));
    }

}
