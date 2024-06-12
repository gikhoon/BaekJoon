package BaekJoon2225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N + 1; i++) {
            dp[i][1] = 1;
        }

        for (int j = 2; j < K + 1; j++) {
            int sum = 0;
            for (int i = 0; i < N + 1; i++) {
                sum = (sum + dp[i][j - 1]) % 1_000_000_000;
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[N][K]);
    }
}
