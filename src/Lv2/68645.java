package Lv2;

class Sol_68645 {
    static int[][] matrix;
    static int len;
    public static int[] solution(int n) {
        len = (n * (n + 1)) / 2;
        int[] answer = new int[len];

        matrix = new int[n][n]; // 정사각형 2차원 배열
        matrix[0][0] = 1;

        goBottom(1, 0, 2);

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[index] = matrix[i][j];
                index++;
            }
        }
        return answer;
    }

    public static void goBottom(int i, int j, int count) {
        int n = matrix.length;

        while (i < n && matrix[i][j] == 0) {
            matrix[i][j] = count++;
            i++;
        }
        if (count > len) {
            return;
        }
        goRight(i - 1, j + 1, count);
    }

    public static void goRight(int i, int j, int count) {
        int n = matrix.length;

        while (j < n && matrix[i][j] == 0) {
            matrix[i][j] = count++;
            j++;
        }
        if (count > len) {
            return;
        }
        goDiagonalUp(i - 1, j - 2, count);
    }

    public static void goDiagonalUp(int i, int j, int count) {
        while (i >= 0 && j >= 0 && matrix[i][j] == 0) {
            matrix[i][j] = count++;
            i--;
            j--;
        }
        goBottom(i + 2, j + 1, count);
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }

}
