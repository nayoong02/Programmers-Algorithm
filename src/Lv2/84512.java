package Lv2;

class Sol_845152 {
    static char[] words = {'A', 'E', 'I', 'O', 'U'}; // 알파벳 모음
    static int max_len = 5; // 단어 최대 길이
    static int count, answer = 0; // 순서

    public static int solution(String word) {
        dfs(0, "", word);

        return answer;
    }

    static void dfs(int idx, String temp, String word) {
        if (idx == max_len) { // 탈출 조건
            return;
        }

        for (int i = 0; i < words.length; i++) {
            String ss = temp + words[i];
            count++;
            if (ss.equals(word)) {
                answer = count;
                return;
            }
            dfs(idx + 1, ss, word);
        }
    }

    public static void main(String[] args) {
        String word = "I";
        System.out.println(solution(word));
    }

}
