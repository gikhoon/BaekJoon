import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter sw = new OutputStreamWriter(System.out);
        int n = Integer.parseInt(br.readLine());
        list = new int[n];
        dp = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        checkDP();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (dp[a-1][b-1]) {
                sw.append("1\n");
            } else {
                sw.append("0\n");
            }
        }

        sw.flush();
        sw.close();
    }

    private static void checkDP() {
        for (int i = 0; i < list.length; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < list.length - 1; i++) {
            if (list[i] == list[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        for (int i =2;i<list.length;i++) {
            for (int j=0;j + i <list.length;j++) {
                if (dp[j + 1][j + i - 1] && list[j] == list[j + i]) {
                    dp[j][j + i] = true;
                }
            }
        }
    }
}