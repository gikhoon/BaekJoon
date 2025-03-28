import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int[] height;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] down = new int[h + 2];
        int[] up = new int[h + 2];
        for (int i = 0; i < n / 2; i++) {
            int d = Integer.parseInt(br.readLine());
            int u = h - Integer.parseInt(br.readLine())+1;
            down[d]++;
            up[u]++;
        }
        for (int i = 1; i <= h; i++) {
            down[i] += down[i - 1];
        }
        for (int i = h; i >= 1; i--) {
            up[i] += up[i + 1];
        }

        int min = n;
        int cnt = 0;
        for (int i = 1; i < h + 1; i++) {
            int dif = down[h] - down[i - 1] + up[1] - up[i + 1];

            if (dif < min) {
                min = dif;
                cnt = 1;
            } else if (dif == min) {
                cnt++;
            }
        }
        System.out.println(min+" "+cnt);
    }
}
