import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] game;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        game = new int[N][3];
        int[][] maxDp = new int[N][3];
        int[][] minDp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                game[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) {
            maxDp[N - 1][i] = game[N - 1][i];
            minDp[N - 1][i] = game[N - 1][i];
        }

        for (int i = N - 2; i >= 0; i--) {
            int max01 = Math.max(maxDp[i + 1][0], maxDp[i + 1][1]);
            maxDp[i][0] = game[i][0] + max01;
            maxDp[i][1] = game[i][1] + Math.max(max01,maxDp[i+1][2]);
            maxDp[i][2] = game[i][2] + Math.max(maxDp[i + 1][1], maxDp[i + 1][2]);

            int min01 = Math.min(minDp[i + 1][0], minDp[i + 1][1]);
            minDp[i][0] = game[i][0] + min01;
            minDp[i][1] = game[i][1] + Math.min(min01,minDp[i+1][2]);
            minDp[i][2] = game[i][2] + Math.min(minDp[i + 1][1], minDp[i + 1][2]);
        }

        int min = Math.min(Math.min(minDp[0][0], minDp[0][1]), minDp[0][2]);
        int max = Math.max(Math.max(maxDp[0][0], maxDp[0][1]), maxDp[0][2]);

        System.out.println(max + " " + min);
    }
}