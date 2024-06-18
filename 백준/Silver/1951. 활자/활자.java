import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int MOD = 1234567;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long total = 0;
        while (N > 9) {
            int len = Long.toString(N).length();
            total += (long) ((N - Math.pow(10, len - 1) + 1) * len);
            N = (long) (Math.pow(10, len - 1) - 1);
        }
        total += N;

        System.out.println(total % MOD);
    }
}
