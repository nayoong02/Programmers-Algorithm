package Lv1;

class Sol_72410 {
    public static String solution(String new_id) {
        String answer = "";

        answer = new_id.toLowerCase(); // 1.

        answer = answer.replaceAll("[^a-z0-9-_.]*", ""); // 2.

        answer = answer.replaceAll("[..]+", "."); // 3.

        answer = answer.replaceAll("^[.]|[.]$", ""); // 4.

        if (answer.equals("")) answer += "a"; // 5.

        if (answer.length() >= 16) { // 6.
            answer = answer.substring(0, 15);
            answer = answer.replaceAll("[.]$", "");
        }

        if (answer.length() <= 2) { // 7.
            while(answer.length() != 3) {
                answer += answer.split("")[answer.length() - 1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String new_id = "...!@BaT#*..y.abcdefghijklm";
        System.out.print(solution(new_id));
    }

}
