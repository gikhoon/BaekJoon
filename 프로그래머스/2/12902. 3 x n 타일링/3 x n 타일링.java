class Solution {
    static int MOD = 1_000_000_007;
    public int solution(int n) {
        if (n % 2 != 0) return 0;
        int m = n / 2;
        long[] dp = new long[m+1];
        dp[0] = 1;
        dp[1] = 3;
        long sum = 1;  // sum = dp[0]

        for (int i = 2; i <= m; i++) {
            dp[i] = (dp[i-1] * 3 + sum * 2) % MOD;
            sum = (sum + dp[i-1]) % MOD;
        }
        return (int) dp[m];
    }
}