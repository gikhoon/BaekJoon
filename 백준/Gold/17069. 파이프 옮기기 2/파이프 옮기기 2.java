import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static long[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new boolean[N + 2][N + 2];
        dp = new long[N + 2][N + 2][3];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("0")) map[i][j] = true;
            }
        }

        dp[1][2][0] = 1;

        for (int i = 1; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                if (!map[i][j]) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if (map[i - 1][j] && map[i][j - 1]) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }
            }
        }


        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }
}