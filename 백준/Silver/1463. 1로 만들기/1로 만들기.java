import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        count = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            count[i] = count[i - 1] + 1;
            if (i % 2 == 0) {
                count[i] = Math.min(count[i], count[i / 2] + 1);
            }
            if (i % 3 == 0) {
                count[i] = Math.min(count[i], count[i / 3] + 1);
            }
        }

        System.out.println(count[N]);
    }
}
