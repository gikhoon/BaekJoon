import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int testCase = 0;

		while (true) {
			testCase++;
			int N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			dp = new int[N][3];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 3; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i < N; i++) {
				if (i == 1) {
					for (int j = 0; j < 3; j++) {
						if (j == 0)
							dp[i][0] += dp[i - 1][1];
						else {
							dp[i][j] += Math.min(dp[i][j - 1],
								Math.min(dp[i - 1][1], dp[i - 1][1] + dp[i - 1][2]));
						}
					}
				} else {
					dp[i][0] += Math.min(dp[i - 1][0], dp[i - 1][1]);
					dp[i][1] += Math.min(Math.min(dp[i][0], dp[i - 1][0]),
						Math.min(dp[i - 1][1], dp[i - 1][2]));
					dp[i][2] += Math.min(dp[i][1], Math.min(dp[i - 1][1], dp[i - 1][2]));
				}
			}

			sb.append(testCase).append(". ").append(dp[N-1][1]).append("\n");

		}

		System.out.println(sb);
	}
}