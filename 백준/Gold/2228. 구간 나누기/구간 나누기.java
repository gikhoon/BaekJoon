import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] sum;
    static int[][] dp;
    static boolean[][] isVisited;

    static int init = Integer.MIN_VALUE / 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sum = new int[N + 1];
        dp = new int[N + 1][M + 1];
        isVisited = new boolean[N + 1][M + 1];

        for (int i = 1; i < N + 1; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N + 1; i++) {
            Arrays.fill(dp[i], init);
        }

        System.out.println(solve(N, M));


    }

    private static int solve(int index, int section) {
        if (section == 0) return 0;
        if (index < 0) return init;

        if (isVisited[index][section]) return dp[index][section];

        isVisited[index][section] = true;
        dp[index][section] = solve(index - 1, section);
        for (int i = index; i > 0; i--) {
            dp[index][section] = Math.max(dp[index][section], solve(i - 2, section - 1) + sum[index] - sum[i - 1]);
        }

        return dp[index][section];
    }
}