import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] cost;
    static int[][] dp;
    static int N;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[N - 1][i] = cost[N - 1][i];
        }
        if (N == 2) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j) continue;
                    answer = Math.min(cost[0][i] + cost[1][j], answer);
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                firstHouse(i);
                for (int k = N - 3; k > 0; k--) {
                    dp[k][0] = cost[k][0] + Math.min(dp[k + 1][1], dp[k + 1][2]);
                    dp[k][1] = cost[k][1] + Math.min(dp[k + 1][0], dp[k + 1][2]);
                    dp[k][2] = cost[k][2] + Math.min(dp[k + 1][0], dp[k + 1][1]);
                }

                if (i == 0) {
                    answer = Math.min(cost[0][0] + Math.min(dp[1][1], dp[1][2]), answer);
                } else if (i == 1) {
                    answer = Math.min(cost[0][1] + Math.min(dp[1][0], dp[1][2]), answer);
                } else {
                    answer = Math.min(cost[0][2] + Math.min(dp[1][0], dp[1][1]), answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static void firstHouse(int i) {
        if (i == 0) {
            dp[N - 2][0] = cost[N - 2][0] + Math.min(cost[N - 1][1], cost[N - 1][2]);
            dp[N - 2][1] = cost[N - 2][1] + cost[N - 1][2];
            dp[N - 2][2] = cost[N - 2][2] + cost[N - 1][1];
        } else if (i == 1) {
            dp[N - 2][0] = cost[N - 2][0] + cost[N - 1][2];
            dp[N - 2][1] = cost[N - 2][1] + Math.min(cost[N - 1][0], cost[N - 1][2]);
            dp[N - 2][2] = cost[N - 2][2] + cost[N - 1][0];
        } else {
            dp[N - 2][0] = cost[N - 2][0] + cost[N - 1][1];
            dp[N - 2][1] = cost[N - 2][1] + cost[N - 1][0];
            dp[N - 2][2] = cost[N - 2][2] + Math.min(cost[N - 1][0], cost[N - 1][1]);
        }

    }
}