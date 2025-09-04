import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        sum = new int[N][3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            sum[0][i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            sum[i][0] = Integer.parseInt(st.nextToken()) + Math.min(sum[i-1][1], sum[i-1][2]);
            sum[i][1] = Integer.parseInt(st.nextToken()) + Math.min(sum[i-1][0], sum[i-1][2]);
            sum[i][2] = Integer.parseInt(st.nextToken()) + Math.min(sum[i-1][0], sum[i-1][1]);
        }

        System.out.println(Arrays.stream(sum[N-1]).min().getAsInt());
    }
}
