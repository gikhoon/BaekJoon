import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static long[][][][][][][] dp;
    static int[] count;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        count = new int[6];
        for (int i = 1; i <= N; i++) {
            count[i] = Integer.parseInt(br.readLine());
        }

        dp = new long[count[1] + 1][count[2] + 1][count[3] + 1][count[4] + 1][count[5] + 1][N + 1][N + 1];

        System.out.println(fillDP(count, 0, 0));
    }

    private static long fillDP(int[] count, int pre, int ppre) {
        if (count[1] == 0 && count[2] == 0 && count[3] == 0 && count[4] == 0 && count[5] == 0) {
            return 1;
        }

        long cur = dp[count[1]][count[2]][count[3]][count[4]][count[5]][pre][ppre];
        if (cur != 0 && cur != -1) {
            return cur;
        }

        if (cur == -1) {
            return 0;
        }

        for (int i = 1; i <= 5; i++) {
            if (pre != i && ppre != i && count[i] > 0) {
                count[i]--;
                cur += fillDP(count, i, pre);
                count[i]++;
            }
        }

        if (cur == 0) {
            dp[count[1]][count[2]][count[3]][count[4]][count[5]][pre][ppre] = -1;
        } else {
            dp[count[1]][count[2]][count[3]][count[4]][count[5]][pre][ppre] = cur;
        }

        return cur;
    }
}