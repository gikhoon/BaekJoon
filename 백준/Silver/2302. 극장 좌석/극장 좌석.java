
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    static int[] memo;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        memo = new int[N+2];
        memo[1] = 1;
        memo[0] = 1;
        memo[2] = 2;
        int M = Integer.parseInt(br.readLine());
        int l = 0;
        int answer = 1;
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            answer *= find(vip - l - 1);
            l = vip;
        }
        answer *= find(N - l);
        System.out.println(answer);
    }

    private static int find(int num) {
        if (memo[num] != 0) {
            return memo[num];
        }

        memo[num] = 2 * find(num-2) + find(num-3);
        return memo[num];
    }
}
