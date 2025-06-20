import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        if (N <= K) {
            System.out.println(0);
            return;
        }
        int[] censors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            censors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(censors);

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = censors[i + 1] - censors[i];
        }

        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);
    }
}