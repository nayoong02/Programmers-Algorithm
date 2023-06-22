package Lv2;

class Sol_42842 {
    public static int[] solution(int brown, int yellow) {

        int width = 2; // 전체 너비 (최소 3인데 밑에 반복문에서 1 더하고 시작하므로)
        int height = 3; // 전체 높이 (최소 3)
        int sum = brown + yellow; // 전체 격자 개수

        boolean flag = true;
        int[] answer;

        while (flag) {
            width++;
            for (height = 3; height <= width; height++) { // 가로 >= 세로 이므로
                if ((height * width == sum) && (height - 2) * (width - 2) == yellow) {
                    flag = false;
                    break;
                }
            }
        }

        answer = new int[]{width, height};
        return answer;
    }

    public static void main(String[] args) {
        int brown = 24;
        int yellow = 24;
        System.out.println(solution(brown, yellow));
    }

}
