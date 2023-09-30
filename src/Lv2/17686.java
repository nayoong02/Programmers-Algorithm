package Lv2;

import java.util.*;

class Sol_17686 {
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];

        ArrayList<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) { // 리스트에 files 배열 할당 + File 객체, 들어온 순서 전달
            list.add(new File(files[i], i));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) { // head, number, tail 연결해서 answer 배열에 저장
            answer[i] = list.get(i).head + list.get(i).num + list.get(i).tail;
        }

        return answer;
    }

    static class File implements Comparable<File> {
        int order; // 들어온 순서
        String head;
        String num;
        String tail;

        File(String str, int order) {
            this.order = order;

            // head
            int idx = 0;
            while (true) {
                if (str.charAt(idx) >= '0' && str.charAt(idx) <= '9') { // 숫자 만나기 전까지 인덱스 증가
                    break;
                } else idx++;
            }
            this.head = str.substring(0, idx);

            // num
            String tmp = "";
            while (true) {
                if (idx < str.length() && Character.isDigit(str.charAt(idx))) {
                    tmp += str.charAt(idx);
                    idx++;
                } else break;
            }
            this.num = tmp;

            // tail
            this.tail = str.substring(idx);
        }

        @Override
        public int compareTo(File o) {
            String h1 = this.head.toLowerCase();
            String h2 = o.head.toLowerCase();

            if (h1.equals(h2)) { // head가 같으면
                if (this.num == o.num) { // num이 같으면
                    return this.order - o.order;
                }
                return Integer.parseInt(this.num) - Integer.parseInt(o.num);
            }
            return h1.compareTo(h2);
        }
    }

    public static void main (String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(solution(files));
    }
}
