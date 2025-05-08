import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {0, 1};
    static int[] dc = {1, 0};
    static int[][] map;
    static BigInteger[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new BigInteger[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[N - 1][N - 1] = BigInteger.ONE;

        for (int i = N - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (i == N-1 && j == N-1) continue;
                dp[i][j] = BigInteger.ZERO;
                for (int d = 0; d < 2; d++) {
                    int newR = i + dr[d] * map[i][j];
                    int newC = j + dc[d] * map[i][j];
                    if (isNotValid(newR, N) || isNotValid(newC, N)) continue;
                    dp[i][j] = dp[i][j].add(dp[newR][newC]);
                }
            }
        }

        System.out.println(dp[0][0]);
    }

    static boolean isNotValid(int num, int N) {
        return num >= N;
    }

    /**
     * 4
     * 2 3 3 1
     * 1 2 1 3
     * 1 2 3 1
     * 3 1 1 0
     *
     * 3 1 1 0
     * 3 1 0 0
     * 2 1 0 1
     * 1 1 1 1
     */
}