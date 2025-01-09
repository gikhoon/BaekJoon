import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            int d = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] map = new int[d];

            for (int j = 0; j < d; j++) {
                int money = Integer.parseInt(st.nextToken());
                map[j] = money;
            }

            int max = map[d - 1];
            long sum = 0;
            for (int j=d-2;j>=0;j--) {
                if (map[j] > max) {
                    max = map[j];
                } else {
                    sum += max - map[j];
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
