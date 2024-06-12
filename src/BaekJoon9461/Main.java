package BaekJoon9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];

        int max = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(br.readLine());
            max = Math.max(list[i], max);
        }

        long[] dp = new long[max + 3];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= max; i++) {
            dp[i] = dp[i - 2] + dp[i - 3];
        }

        for (int i : list) {
            System.out.println(dp[i]);
        }
    }
}

