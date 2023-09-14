package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

class Sol_176962 {
    public static String[] solution(String[][] plans) {
        PriorityQueue<Task> queue = new PriorityQueue<>(); // 우선순위 큐

        for (String[] plan : plans) {
            queue.add(new Task(plan));
        }

        Stack<Task> remainingStack = new Stack<>(); // 잠시 멈춘 과제들 보관
        List<String> answerList = new ArrayList<>();

        while (!queue.isEmpty()) {
            Task currTask = queue.poll();
            int currTime = currTask.start;

            // 새로운 과제가 남아있는 경우
            if (!queue.isEmpty()) {
                Task nextTask = queue.peek();

                // 새로운 과제 시작 시간 < 지금 과제 끝나는 시간
                if (nextTask.start < currTime + currTask.playtime) {
                    // 현재 과제 잠깐 멈추고 스택에 추가
                    int gap = nextTask.start - currTime;
                    remainingStack.add(new Task(currTask.name, currTask.playtime - gap));
                }
                // 지금 과제 끝난 시간이 새로운 과제 시작할 시간이면
                else if (nextTask.start == currTime + currTask.playtime) {
                    // 과제 완료
                    answerList.add(currTask.name);
                }
                else {
                    answerList.add(currTask.name);
                    currTime += currTask.playtime;

                    // 잠시 멈춘 과제 있다면
                    while (!remainingStack.isEmpty()) {
                        Task remainingTask = remainingStack.pop();

                        // 다음 과제 시작 시간 전까지 남은 과제 끝낼 수 있으면
                        if (currTime + remainingTask.playtime <= nextTask.start) {
                            // 과제 완료
                            answerList.add(remainingTask.name);
                            currTime += remainingTask.playtime;
                        } else {
                            int gap = nextTask.start - currTime;
                            remainingStack.add(new Task(remainingTask.name, remainingTask.playtime - gap));
                            break;
                        }
                    }
                }
            }
            // 남아있는 새로운 과제 없는 경우
            else {
                // 잠시 멈춘 과제도 없는 경우
                if (remainingStack.isEmpty()) {
                    answerList.add(currTask.name);
                    currTime += currTask.playtime;
                }
                // 스택에 남아있는 과제 있는 경우
                else {
                    answerList.add(currTask.name);

                    while (!remainingStack.isEmpty()) {
                        Task remainingTask = remainingStack.pop();
                        answerList.add(remainingTask.name);
                    }
                }
            }
        }
        return answerList.toArray(String[]::new);
    }

    static class Task implements Comparable<Task> {
        private String name;
        private Integer start;
        private Integer playtime;

        public Task(String name, String start, String playtime) {
            this.name = name;
            String[] splitStart = start.split(":");
            this.start = Integer.parseInt(splitStart[0]) * 60 + Integer.parseInt(splitStart[1]);
            this.playtime = Integer.parseInt(playtime);
        }

        public Task(String name, Integer playtime) {
            this.name = name;
            this.playtime = playtime;
        }

        public Task(String[] plan) {
            this(plan[0], plan[1], plan[2]);
        }

        // 시작시간 기준 오름차순
        @Override
        public int compareTo(Task t) {
            return this.start - t.start;
        }
    }

    public static void main(String[] args) {
        String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        System.out.println(solution(plans));
    }
}
