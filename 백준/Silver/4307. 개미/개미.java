import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int minC = -1;
            double min = Double.MAX_VALUE;
            int max = -1;

            double middle = (double)l / 2;

            for (int i = 0; i < n; i++) {
                int c = Integer.parseInt(br.readLine());
                if (Math.abs(middle - c) < min) {
                    min = Math.abs(middle - c);
                    minC = c;
                }

                max = Math.max(max, Math.max(c, l - c));
            }

            sb.append(Math.min(minC, l - minC)).append(" ").append(max).append("\n");
        }

        System.out.println(sb);

    }
}