package Lv1;

import java.util.*;

class Sol_1845 {
    public static int solution(int[] nums) {
        int select = nums.length / 2; // 뽑으려는 개수
        Arrays.sort(nums); // 배열 오름차순 정렬
        HashSet<Integer> set = new HashSet<>();

        // hashset 에 nums 원소 집어넣기 (중복 제외)
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        if (set.size() < select) return set.size();
        else return select;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 3};
        System.out.println(solution(nums));
    }

}
