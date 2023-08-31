package Lv2;

class Sol_17687 {
    public static String solution(int n, int t, int m, int p) {
        StringBuilder convert = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; convert.length() <= t * m; i++) {
            convert.append(Integer.toString(i, n)); // i를 n진법으로 변환해서 저장
        }

        for (int i = p - 1; answer.length() < t; i += m) { // 순서대로 t개 answer에 저장
            answer.append(convert.charAt(i));
        }

        return answer.toString().toUpperCase();
    }

    public static void main(String[] args) {
        int n = 2;
        int t = 4;
        int m = 2;
        int p = 1;
        System.out.println(solution(n, t, m, p));
    }
}
