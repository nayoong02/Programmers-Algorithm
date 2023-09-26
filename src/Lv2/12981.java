package Lv2;

import java.util.*;

class Sol_12981 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[]{0, 0}; // 정답 배열

        // 리스트 초기화
        ArrayList<String>[] list = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<String>();
        }

        int round = 0; // 차례
        int seq = 0; // 순서
        boolean flag = true;

        for (int i = 0; i < words.length; i++) {
            round = (i + n) / n; // 차례 1 증가

            seq = (i + n) % n; // 말하는 순서
            String word = words[i]; // 현재 단어

            if (i != 0 && word.charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) { // 첫 번째 차례 아니고 뒤에 단어 끝말잇기 안되면
                flag = false;
                break;
            }

            HashSet<String> set = new HashSet<>();
            if (!set.contains(word)) { // 아직 set에 포함 안된 단어면
                set.add(word);
                list[seq].add(word); // 그 사람의 순서 리스트에 넣기
            }
            else { // 이미 한 번 거론된 단어라면
                flag = false;
                break;
            }
        }

        if (flag) { // 아무 이상 없이 종료됐다면
            answer = new int[]{0, 0};
        }
        else { // 끝말잇기 중간에 탈락자 발생했다면
            answer[0] = seq + 1;
            answer[1] = round;
        }

        return answer;
    }


    public static void main(String[] args) {
        int n = 5;
        String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        System.out.println(solution(n, words));
    }
}
