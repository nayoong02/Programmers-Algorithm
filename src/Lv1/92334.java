package Lv1;

import java.util.HashMap;
import java.util.HashSet;

class Sol_92334 {
    public static int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String, Integer> id_Map = new HashMap<>(); //id 이름, 인덱스 순서
        HashMap<String, HashSet<String>> map = new HashMap<>(); //id, id를 신고한 사람 set
        int[] answer = new int[id_list.length]; //count 담을 배열

        //id_Map 초기화
        for (int i = 0; i < id_list.length; i++){
            id_Map.put(id_list[i], i);
            map.put(id_list[i], new HashSet<String>());
        }

        //report 분해
        for (String s : report){
            String from = s.split(" ")[0]; //신고한 사람
            String to = s.split(" ")[1]; //신고 당한 사람
            map.get(to).add(from); //신고 당한 사람에 신고한 사람 id 추가
        }

        //k번 이상 신고 당한 사람을 신고한 사람 메일 발송
        for (int i = 0; i < id_list.length; i++){
           if(map.get(id_list[i]).size() >= k) { //HashSet의 크기가 k 이상일때 Set에 있는 사람들에게 메일 발송
               for(String name : map.get(id_list[i])){
                   answer[id_Map.get(name)]++;
               }
           }
        }

        return answer;
    }

    public static void main(String args[]){
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int[] answer = solution(id_list, report, 2);
        for(int i:answer){
            System.out.println(i);
        }

    }
}