package Lv1;

import java.util.ArrayList;
import java.util.List;

class Sol_42862 {
    public static int solution(int n, int[] lost, int[] reserve) {
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();

        for (int l : lost) {
            lostList.add(l);
        }

        for (int r : reserve) {
            reserveList.add(r);
        }

        for (int l : lost) {
            if (reserveList.contains(l)) {
                lostList.remove((Integer) l);
                reserveList.remove((Integer) l);
            }
        }

        for (int l : lostList) {
            for (int r : reserveList) {
                if (Math.abs(l - r) == 1) {
                    reserveList.remove((Integer) r);
                    lostList.remove((Integer) l);
                    break;
                }
            }
        }

        return n - lostList.size();
    }


    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve= {1, 3, 5};
        System.out.println(solution(n, lost, reserve));
    }
}
