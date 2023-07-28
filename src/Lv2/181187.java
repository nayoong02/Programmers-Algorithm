package Lv2;

class Sol_181187 {
    public static long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long minY = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * x * x)); // 작은 원의 x 좌표의 해당하는 y 좌표
            long maxY = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * x * x)); // 큰 원의 x 좌표의 해당하는 y 좌표

            answer += (maxY - minY + 1);
        }

        return answer * 4;
    }

    public static void main(String[] args) {
       int r1 = 2;
       int r2 = 3;
       System.out.println(solution(r1, r2));
    }

}
