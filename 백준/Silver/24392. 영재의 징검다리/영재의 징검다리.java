import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int sum = 0;
                    for (int d = -1; d <= 1; d++) {
                        int newJ = j+d;
                        if (newJ < 0 || newJ >= M) {
                            continue;
                        }
                        sum = (sum + map[i - 1][newJ]) % MOD;
                    }
                    map[i][j] = sum;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < M; i++) {
            sum = (sum + map[N - 1][i]) % MOD;
        }

        System.out.println(sum);
    }
}
