package Lv2;

import java.util.*;

class Sol_17686 {
    public static String[] solution(String[] files) {

        Arrays.sort(files, (s1, s2) -> {
            String head1 = s1.split("[0-9]")[0];
            String head2 = s2.split("[0-9]")[0];

            s1 = s1.replace(head1, "");
            s2 = s2.replace(head2, "");

            head1 = head1.toLowerCase();
            head2 = head2.toLowerCase();

            if (head1.compareTo(head2) == 0) { // HEAD가 같으면 NUMBER로 정렬
                String num1 = "";
                for (char c : s1.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        num1 += c;
                    } else break;
                }

                String num2 = "";
                for (char c : s2.toCharArray()) {
                    if (c >= '0' && c <= '9') {
                        num2 += c;
                    } else break;
                }

                return Integer.parseInt(num1) - (Integer.parseInt(num2));
            }
            else { // HEAD가 달라서 정렬 가능하면
                return head1.compareTo(head2);
            }
        });
        return files;
    }

    public static void main (String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(files));
    }
}
