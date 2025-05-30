import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isVisited;
    static List<Integer>[] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][2];
        isVisited = new boolean[N + 1];
        graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static void dfs(int number) {
        isVisited[number] = true;
        dp[number][1] = 1;

        for (int child : graph[number]) {
            if (!isVisited[child]) {
                dfs(child);
                dp[number][0] += dp[child][1];
                dp[number][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}
