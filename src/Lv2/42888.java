package Lv2;

import java.util.*;

class Sol_42888 {

    static Map<String, String> n_map = new HashMap<>();
    static LinkedList<String> ansList = new LinkedList<>();

    public static String[] solution(String[] record) {

        // 닉네임 업데이트
        for (String rec : record) {
            String[] splitRecord = rec.split(" ");
            String command = splitRecord[0]; // Enter, Leave, Change
            String userId = splitRecord[1]; // 유저 아이디

            if (command.equals("Enter") || command.equals("Change")) {
                String nickname = splitRecord[2]; // 닉네임
                n_map.put(userId, nickname); // 닉네임 변경
            }
        }

        // 채팅메시지 추가
        for (String rec : record) {
            String[] splitRecord = rec.split(" ");
            String command = splitRecord[0]; // Enter, Leave, Change
            String userId = splitRecord[1]; // 유저 아이디

            switch (command) {
                case "Enter":
                    ansList.add(n_map.get(userId) + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    ansList.add(n_map.get(userId) + "님이 나갔습니다.");
                    break;
            }
        }

        String[] answer = new String[ansList.size()];
        return ansList.toArray(answer);
    }

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(solution(record));
    }
}
