import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] weights = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            set.add(weights[i]);
            if (weights[i] == C) {
                System.out.println(1);
                return;
            }
        }

        Arrays.sort(weights);

        int left = 0;
        int right = N - 1;

        while (left < right) {
            int weight = weights[left] + weights[right];

            if (weight > C) {
                right--;
                continue;
            }

            if (weight == C) {
                System.out.println(1);
                return;
            }

            int remain = C - weight;

            if (set.contains(remain) && remain != weights[left] && remain != weights[right]) {
                System.out.println(1);
                return;
            }

            left++;
        }

        System.out.println(0);
    }
}
