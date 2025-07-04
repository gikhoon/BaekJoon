import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int[] A;
    static int[] B;
    static Map<Integer, Integer> diffMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        B = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            A[i] = A[i - 1] + Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            B[i] = B[i - 1] + Integer.parseInt(st.nextToken());
        }

        diffMap.put(0, 1);
        long sum = 0;
        for (int i = 1; i <= N; i++) {
            int diff = A[i] - B[i];

            sum += diffMap.getOrDefault(diff, 0);
            diffMap.put(diff, diffMap.getOrDefault(diff, 0) + 1);
        }

        System.out.println(sum);
    }
}