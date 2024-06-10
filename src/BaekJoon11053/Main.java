package BaekJoon11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] dp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i < N + 1; i++) {
            int max = 1;
            for (int j = i - 1; j >= 0; j--) {
                if ((arr[i] > arr[j]) && (max < dp[j] + 1)) {
                    max = dp[j] + 1;
                }
            }
            dp[i] = max;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
