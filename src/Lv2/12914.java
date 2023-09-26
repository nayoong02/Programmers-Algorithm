package Lv2;

class Sol_12914 {
    public long solution(int n) {
        long[] dp = new long[2001];

        // 피보나치
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }

        return dp[n];
    }

}
