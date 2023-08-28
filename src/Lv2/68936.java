package Lv2;

class Sol_68936 {
    public static int zero_count;
    public static int one_count;

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];
        zero_count = 0;
        one_count = 0;
        int half_len = arr.length;

        compression(arr, 0, 0, half_len);

        answer = new int[]{zero_count, one_count};
        return answer;
    }

    // 압축
    public static void compression(int[][] arr, int x, int y, int half_len) {
        if (half_len == 1) {
            if (arr[x][y] == 1) {
                one_count++;
            } else {
                zero_count++;
            }
            return;
        }

        if (check(arr, x, y, half_len)) { // 정사각형 안 모두 같은 원소인지 체크
            return;
        }

        int new_half_len = half_len / 2; // half_len 갱신

        // 4분면 재귀호출
        compression(arr, x, y, new_half_len);
        compression(arr, x, y + new_half_len, new_half_len);
        compression(arr, x + new_half_len, y, new_half_len);
        compression(arr, x + new_half_len, y + new_half_len, new_half_len);

    }

    // 정사각형 안에 모두 같은 원소인지 체크
    public static boolean check(int[][] arr, int x, int y, int half_len) {
        boolean flag = true;
        int temp = arr[x][y];

        for (int i = x; i < x + half_len; i++) {
            for (int j = y; j < y + half_len; j++) {
                if (temp != arr[i][j]) { // 하나라도 다르면 바로 false
                    flag = false;
                    break;
                }
            }
        }

        if (flag) { // 모두 같은 값이면 해당 숫자 카운트 +1
            if (temp == 1) one_count++;
            else zero_count++;
        }

        return flag;
    }

    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(arr);
    }

}
