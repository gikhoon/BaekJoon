import java.io.*;
import java.util.*;

public class Main {
	static int[] dp;
	static int INF = 1_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		dp = new int[C + 101];
		Arrays.fill(dp, INF);
		dp[0] = 0;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int cost = Integer.parseInt(st.nextToken());
			int costumer = Integer.parseInt(st.nextToken());
			for (int c = costumer; c < C + 101; c++) {
				dp[c] = Math.min(dp[c], dp[c - costumer] + cost);
			}
		}

		int answer= Integer.MAX_VALUE;
		for(int i=C;i<C+101;i++) {
			answer = Math.min(answer, dp[i]);
		}

		System.out.println(answer);
	}
}
