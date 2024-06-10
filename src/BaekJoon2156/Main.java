package BaekJoon2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];
        int[] max = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(dp[1]);
            return;
        }
        max[0] = 0;
        max[1] = dp[1];
        max[2] = dp[1] + dp[2];

        for (int i = 3; i < n + 1; i++) {
            max[i] = Math.max((dp[i] + Math.max((dp[i - 1] + max[i - 3]), max[i - 2])), max[i - 1]);
        }

        System.out.println((max[n]));

    }
}
