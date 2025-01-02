import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static HashMap<Long, Long> memo = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());
        long Q = Long.parseLong(st.nextToken());

        System.out.println(solve(N, P, Q));
    }

    private static long solve(long num, long P, long Q) {
        if (num == 0) {
            return 1;
        }
        if (memo.containsKey(num)) {
            return memo.get(num);
        }

        long newMemo = solve(num / P, P, Q) + solve(num / Q, P, Q);
        memo.put(num, newMemo);
        return newMemo;
    }
}
