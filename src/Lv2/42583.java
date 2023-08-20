package Lv2;

import java.util.*;

class Sol_42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> queue = new LinkedList<>();
        int sum = 0;
        int time = 0;

        for (int i = 0; i < truck_weights.length; i++) {
            int truck = truck_weights[i];

            while (true) { // 트럭 넣을 때까지 반복
                if (queue.isEmpty()) { // 큐가 비어 있으면 트럭 추가
                    queue.add(truck);
                    sum += truck;
                    time++;
                    break;
                }
                else if (queue.size() == bridge_length) { // 큐가 꽉 찼으면
                    sum -= queue.poll();
                }
                else { // 큐가 다 차지 않았을 때
                    if (sum + truck > weight) { // 이번 트럭 넣었을때 무게가 넘치면
                        queue.add(0); // 0 넣고 시간만 +1
                        time++;
                    }
                    else { // 무게가 안넘으면 추가
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    }
                }
            }
        }

        return time + bridge_length;
    }
}
