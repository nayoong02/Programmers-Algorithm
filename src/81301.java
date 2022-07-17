class Sol_81301 {
    public static int solution(String s) {
        String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        //영단어는 모두 정수로 대체
        for(int i = 0; i < 10; i++){
            s = s.replace(words[i], num[i]);
        }

        int answer = Integer.parseInt(s);
        return answer;
    }

    public static void main(String args[]){
        System.out.println(solution("one4seveneight"));
    }
}