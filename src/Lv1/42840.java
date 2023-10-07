package Lv1;

import java.util.*;

class Sol_42840 {
    public int[] solution(int[] answers) {
        int[] firstPerson = {1, 2, 3, 4, 5};
        int[] secondPerson = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == firstPerson[i % firstPerson.length]) {
                firstCount++;
            }
            if (answers[i] == secondPerson[i % secondPerson.length]) {
                secondCount++;
            }
            if (answers[i] == thirdPerson[i % thirdPerson.length]) {
                thirdCount++;
            }
        }

        int maxCount = Math.max(Math.max(firstCount, secondCount), thirdCount);
        ArrayList<Integer> ansList = new ArrayList<>();

        if (firstCount == maxCount) ansList.add(1);
        if (secondCount == maxCount) ansList.add(2);
        if (thirdCount == maxCount) ansList.add(3);

        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }

        return answer;
    }
}
