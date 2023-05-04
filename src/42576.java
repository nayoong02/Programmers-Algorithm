import java.util.*;

class Sol_42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = ""; // 완주하지 못한 선수

        // 오름차순 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);

        // 다를 때까지 반복 -> 다른 선수 찾아내기
        int i = 0;
        for(i = 0; i < completion.length; i++) {
            if(!participant[i].equals(completion[i])) {
                break;
            }
        }

        answer = participant[i];
        return answer;
    }
}