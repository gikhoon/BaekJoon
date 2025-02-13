import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] list;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int a = 1; a <= n; a++) {
            int b = Integer.parseInt(st.nextToken());
            if (b != -1) {
                list[b].add(a);
            }
        }

        dp = new int[n + 1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int man = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            dp[man] += w;
        }
        dfs(1);

        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int m) {
        for (int nxt : list[m]) {
            dp[nxt] += dp[m];
            dfs(nxt);
        }
    }
}
