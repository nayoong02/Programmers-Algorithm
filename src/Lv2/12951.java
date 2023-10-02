package Lv2;

class Sol_12951 {
    public static String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean flag = true; // 첫문자

        for (char c : s.toCharArray()) {
            sb.append(flag ? Character.toUpperCase(c) : Character.toLowerCase(c));
            flag = (c == ' ') ? true : false; // 공백 이후 또는 첫문자일 때 대문자로
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "3people unFollowed me";
        System.out.println(s);
    }
}
