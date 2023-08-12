package Lv3;

import java.util.*;

class Sol_42628 {
    public static int[] solution(String[] operations) {

        PriorityQueue<Integer> lowQueue = new PriorityQueue<>(); // 최소 힙
        PriorityQueue<Integer> highQueue = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙

        for (int i = 0; i < operations.length; i++) {
            String command = operations[i];

            if (command.startsWith("I")) { // 원소 삽입
                lowQueue.add(Integer.valueOf(command.split(" ")[1]));
                highQueue.add(Integer.valueOf(command.split(" ")[1]));
            }
            else if (command.startsWith("D")) {
                if (!lowQueue.isEmpty()) { // 큐가 비어있을 때
                    if (Integer.valueOf(command.split(" ")[1]) == 1) { // 최댓값 제거
                        int max = highQueue.poll();
                        lowQueue.remove(max);
                    }
                    else if (Integer.valueOf(command.split(" ")[1]) == -1) { // 최솟값 제거
                        int min = lowQueue.poll();
                        highQueue.remove(min);
                    }
                }
            }
        }

        int[] arr = new int[2];
        if (lowQueue.isEmpty()) { // 큐가 비어있으면
            arr[0] = 0;
            arr[1] = 0;
        }
        else { // 아직 남아있다면 최댓값, 최솟값 반환
            arr[0] = highQueue.peek();
            arr[1] = lowQueue.peek();
        }

        return arr;
    }

    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};

        System.out.println(solution(operations));
    }
}
