import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] isPal;
    static int[] dp;
    static String[] st;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = br.readLine().split("");
        int n = st.length;
        isPal = new boolean[n][n];

        checkDP();

        dp = new int[n];

        for (int end = 0; end < n; end++) {
            dp[end] = end + 1;
            for (int start = 0; start <= end; start++) {
                if (isPal[start][end]) {
                    if (start == 0) {
                        dp[end] = 1;
                    } else {
                        dp[end] = Math.min(dp[end], dp[start - 1] + 1);
                    }
                }
            }
        }

        System.out.println(dp[n - 1]);
    }

    private static void checkDP() {
        for (int i = 0; i < st.length; i++) {
            isPal[i][i] = true;
        }

        for (int i = 0; i < st.length - 1; i++) {
            if (st[i].equals(st[i + 1])) {
                isPal[i][i + 1] = true;
            }
        }

        for (int i = 2; i < st.length; i++) {
            for (int j = 0; j + i < st.length; j++) {
                if (isPal[j + 1][j + i - 1] && st[j].equals(st[j + i])) {
                    isPal[j][j + i] = true;
                }
            }
        }
    }
}