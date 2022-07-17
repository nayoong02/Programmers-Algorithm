class Sol_77484 {
    public static int[] solution(int[] lottos, int[] win_nums) {
        int low_lotto = 0; //최소한의 겹치는 수
        int add = 0; //0 개수만큼 겹치는 수 증가되게
        int high_lotto = 0; //최대한의 겹치는 수

        //자신의 로또번호와 당첨번호 비교 -> 최소한의 겹치는 수 구함
        for (int i : win_nums){
            for(int j : lottos){
                if(j == i){
                    low_lotto++;
                }
            }
        }

        //자신의 모르는 번호를 다 맞다고 친다면
        for (int k : lottos){
            if(k == 0){
                add++;
            }
        }
        high_lotto = low_lotto + add; //최대 겹치는 수

        int[] answer = {ans(high_lotto), ans(low_lotto)};
        return answer;
    }

    //등수 구하는 함수
    public static int ans(int lotto){
        if (lotto == 0 || lotto == 1) return 6;
        return 7 - lotto;
    }

    public static void main(String args[]){
        int[] lottos = {0, 0, 0, 0, 0, 0};
        int[] win_nums = {38, 19, 20, 40, 15, 25};
        int[] answer = solution(lottos, win_nums);
        for(int i : answer){
            System.out.println(i);
        }

    }
}