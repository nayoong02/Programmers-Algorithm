package Lv1;

class Sol_140108 {
    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            int xCount = 0;
            int nonXcount = 0;

            for (int j = i; j < s.length(); j++) {
                if (s.charAt(j) != x) nonXcount++;
                else xCount++;

                if (xCount == nonXcount || j == s.length() - 1) {
                    answer++;
                    i = j;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String s = "abracadabra";
        System.out.println(solution(s));
    }

}
