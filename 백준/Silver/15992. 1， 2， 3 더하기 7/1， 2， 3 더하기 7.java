import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] memo = new int[1001][1001];
    static int MOD = 1_000_000_009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        memo[1][1] = 1;
        memo[2][1] = 1;
        memo[3][1] = 1;

        for (int m = 2; m <= 1000; m++) {
            for (int n = m; n <= 1000; n++) {
                int sum = 0;
                for (int i = 1; i <= 3; i++) {
                    if (n-i < 0) continue;
                    sum = (sum + memo[n - i][m - 1]) % MOD;
                }
                memo[n][m] = sum;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(memo[n][m]).append("\n");
        }
        System.out.println(sb);
    }
}