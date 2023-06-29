package Lv1;

class Sol_142086 {
    public static int[] solution(String s) {
        int[] answer = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                if (i == j) continue;
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j; // 인덱스 차이
                    break;
                }
            }
            if (answer[i] == 0) answer[i] = -1; // 같은 문자 없으면
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "banana";
        System.out.println(solution(s));
    }

}
