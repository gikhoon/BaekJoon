package BaekJoon9465;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    /**
    * 1-1로 끝나는 것의 최대를 구해 50
    * 1-2로 끝나는 것도 30
     * 2-1, 2-2도 똑같이 구해
     * 3부터는 자기 + [i-1][자기 자리 아닌것]이랑 자기 + [i-2][자기 아님]
     **/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N + 1][2];
            for (int l = 0; l < 2; l++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 1; i < N + 1; i++) {
                    dp[i][l] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1) {
                bw.write(Math.max(dp[1][0], dp[1][1])+"\n");
                continue;
            }

            dp[2][0] = dp[1][1] + dp[2][0];
            dp[2][1] = dp[1][0] + dp[2][1];

            for (int i = 3; i < N + 1; i++) {
                dp[i][0] = dp[i][0] + Math.max(dp[i - 1][1], dp[i - 2][1]);
                dp[i][1] = dp[i][1] + Math.max(dp[i - 1][0], dp[i - 2][0]);
            }
            bw.write(Math.max(dp[N][0], dp[N][1])+"\n");
        }

        bw.flush();
        bw.close();
    }
}
