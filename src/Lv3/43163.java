package Lv3;

class Sol_43163 {
    static boolean[] visited;
    static int answer = 0;

    public static int solution(String begin, String target, String[] words) {

        visited = new boolean[words.length];

        dfs(begin, target, 0, visited, words);

        return answer;
    }

    static void dfs(String temp, String target, int count, boolean[] visited, String[] words) {

        if (temp.equals(target)) { // 현재 문자가 타겟과 같아지면 탈출
            answer = Math.min(Integer.MAX_VALUE, count); // 최소 카운트 구하기 위해
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && onlyOneDiff(temp, words[i])) { // 아직 방문 전 && 한 철자만 다르면
                visited[i] = true;
                dfs(words[i], target, count + 1, visited, words);
                visited[i] = false;
            }
        }

    }

    // 한 철자만 다른지 체크하는 함수
    static boolean onlyOneDiff(String temp, String word) {
        int count = 0; // 다른 철자 개수
        boolean flag = false;

        for (int i = 0; i < word.length(); i++) {
            if (temp.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        if (count == 1) flag = true;

        return flag;
    }

    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.print(solution(begin, target, words));
    }

}
