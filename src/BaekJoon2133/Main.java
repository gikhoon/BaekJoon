package BaekJoon2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 2];

        dp[2] = 3;

        if (N < 4) {
            System.out.println(dp[N]);
            return;
        }
        dp[4] = 11;

        for (int i = 6; i < N + 1; i = i + 2) {

            dp[i] = dp[i - 2] * 3;
            for (int j = i - 4; j > 0; j = j - 2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }

        System.out.println(dp[N]);
    }
}
