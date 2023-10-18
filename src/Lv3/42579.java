package Lv3;

import java.util.*;

class Sol_42579 {
    public static int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>(); // 장르, 총 재생횟수 저장할 맵
        ArrayList<Album> list = new ArrayList<>(); // 노래 객체 저장할 리스트

        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]); // 총 재생횟수 더해주기
            list.add(new Album(genres[i], plays[i], i));
        }

        // 해시맵 총 재생횟수 기준 내림차순 정렬
        ArrayList<Map.Entry<String, Integer>> mapList = new ArrayList<>(map.entrySet());
        Collections.sort(mapList, (a, b) -> b.getValue() - a.getValue());

        // 노래 객체 리스트 정렬
        Collections.sort(list);

        ArrayList<Integer> ansList = new ArrayList<>(); // 정답 리스트
        for (int i = 0; i < mapList.size(); i++) {
            int count = 0;
            String gen = mapList.get(i).getKey(); // 장르

            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).genre.equals(gen)) {
                    ansList.add(list.get(j).idx);
                    count++;

                    if (count == 2) break; // 장르별 노래 최대 2곡
                }
            }
        }

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};

        System.out.println(solution(genres, plays));
    }
}

class Album implements Comparable<Album> {
    String genre;
    int play;
    int idx;

    public Album(String genre, int play, int idx) {
        this.genre = genre;
        this.play = play;
        this.idx = idx;
    }

    @Override
    public int compareTo(Album a) {
        if (a.play == this.play) { // 재생횟수 같으면 인덱스 기준 오름차순
            return this.idx - a.idx;
        }
        return a.play - this.play; // 재생횟수 기준 내림차순
    }
}
