package Lv2;

import java.util.*;

class Sol_92341 {
    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>(); // 차번호, 입차 시각
        Map<String, Integer> answerMap = new TreeMap<>(); // 차번호, 주차누적시간

        for (int i = 0; i < records.length; i++) {
            StringTokenizer st = new StringTokenizer(records[i], " ");

            String time = st.nextToken(); // 입/출차 시각
            String carNum = st.nextToken(); // 차 번호
            String status = st.nextToken(); // 입/출차 상태

            if (status.equals("IN")) { // 입차일 때
                map.put(carNum, time);
                continue;
            } else { // 출차일 때
                int sum = getSum(map.get(carNum), time);
                answerMap.put(carNum, answerMap.getOrDefault(carNum, 0) + sum);
                map.remove(carNum);
            }
        }

        if (!map.isEmpty()) { // 아직 출차 안된 차 남았으면
            for (String carnum : map.keySet()) {
                int sum = getSum(map.get(carnum), "23:59");
                answerMap.put(carnum, answerMap.getOrDefault(carnum, 0) + sum);
            }
        }

        return getAnswer(answerMap, fees);
    }

    // 요금 구해서 배열로 나타내기
    public static int[] getAnswer(Map<String, Integer> answermap, int[] fees) {
        List<Integer> list = new ArrayList<>();

        for (String carnum : answermap.keySet()) {
            int fee = 0;

            if (answermap.get(carnum) <= fees[0]) { // 기본 시간보다 같거나 적다면 기본 요금
                fee += fees[1];
            } else { // 기본 시간 넘었으면 초과 시간만큼 계산
                fee += Math.ceil(((double) answermap.get(carnum) - fees[0]) / fees[2]) * fees[3] + fees[1] ;
            }

            list.add(fee);
        }

        // 리스트 -> 배열로 변환
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    // 출차 - 입차 (주차 누적 시간) 구하기
    public static int getSum(String inTime, String outTime) {
        StringTokenizer st = new StringTokenizer(inTime, ":");
        int in = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(outTime, ":");
        int out = Integer.parseInt(st2.nextToken()) * 60 + Integer.parseInt(st2.nextToken());

        return out - in;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};

        System.out.println(solution(fees, records));
    }
}
