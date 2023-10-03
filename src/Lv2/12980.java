package Lv2;

class Sol_12980 {
    public static int solution(int n) {
        int ans = 0;

        while (n >= 1) {
            if (n % 2 == 1) {
                ans += 1;
            }
            n /= 2;
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(solution(n));
    }
}
