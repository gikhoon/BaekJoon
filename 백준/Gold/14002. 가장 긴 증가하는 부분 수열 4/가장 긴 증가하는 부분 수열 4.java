import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N+1];
        dp = new int[N+1];
        List<Integer>[] dpL = new ArrayList[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 0;
        dp[1] = 1;
        dpL[1] = new ArrayList<>();
        dpL[1].add(arr[1]);

        for (int i=2;i<=N;i++) {
            int max = 1;
            List<Integer> a = new ArrayList<>();
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] < arr[i] && max < dp[j] + 1) {
                    a = dpL[j];
                    max = dp[j] + 1;
                }
            }

            List<Integer> newA = new ArrayList<>(a);
            newA.add(arr[i]);
            dpL[i] = newA;
            dp[i] = max;
        }

        int index = 0;
        for (int i=1;i<=N;i++) {
            if (dp[index] < dp[i]) {
                index = i;
            }
        }

        System.out.println(dp[index]);
        for (int num : dpL[index]) {
            System.out.print(num+" ");
        }
    }
}



