package BaekJoon2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] arr;
    static int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] str = s.split("");
        int length = s.length();
        arr = new int[length + 1];
        int[] dp = new int[length + 2];

        for (int i = 1; i < length + 1; i++) {
            try {
                arr[i] = Integer.parseInt(str[i - 1]);
            } catch (Exception e) {
                System.out.println(0);
                return;
            }
        }
        if (arr[1] == 0) {
            System.out.println(0);
            return;
        }
        dp[1] = 1;
        dp[0] = 1;

        for (int i = 2; i < length + 1; i++) {
            if (arr[i] >= 1 && arr[i] <= 9) {
                dp[i] += dp[i - 1];
                dp[i] %= MOD;
            }
            if (arr[i-1] == 0) continue;

            int ten = arr[i - 1] * 10 + arr[i];

            if (ten == 0) {
                System.out.println(0);
                return;
            }

            if (ten >= 10 && ten <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.println(dp[length]);
    }
}
