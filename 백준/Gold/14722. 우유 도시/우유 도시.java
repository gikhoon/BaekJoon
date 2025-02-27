import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int[][][] dp;
    static int[] dr = {-1, 0};
    static int[] dc = {0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) {
                    dp[i][j][0] = 1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 2; k++) {
                    int pr = i + dr[k];
                    int pc = j + dc[k];
                    if (pr < 0 || pc < 0) continue;
                    for (int l = 0; l < 3; l++) {
                        if (map[i][j] == l) {
                            dp[i][j][l] = Math.max(dp[i][j][l], dp[pr][pc][(l + 2) % 3] + (dp[pr][pc][(l + 2) % 3] == 0 ? 0 : 1));
                        }

                        dp[i][j][l] = Math.max(dp[i][j][l], dp[pr][pc][l]);
                    }
                }
            }
        }

        System.out.println(Math.max(Math.max(dp[N - 1][N - 1][0], dp[N - 1][N - 1][1]), dp[N - 1][N - 1][2]));
    }
}