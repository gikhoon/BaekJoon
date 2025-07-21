import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static int MAX = Integer.MIN_VALUE;
	static int[][] dp;
	static int N;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (dp[i][j] == 0) {
					dp[i][j] = findRoute(i, j);
					MAX = Math.max(dp[i][j], MAX);
				} else {
					MAX = Math.max(dp[i][j], MAX);
				}
			}
		}

		System.out.println(MAX);
	}

	static int findRoute(int r, int c) {
		if (dp[r][c] != 0) {
			return dp[r][c];
		}

		int sum = 1;
		for (int d = 0; d < 4; d++) {
			int newR = r + dr[d];
			int newC = c + dc[d];
			if(newR < 0 || newR >= N || newC < 0 || newC >= N) continue;
			if(map[newR][newC] <= map[r][c]) continue;
			sum = Math.max(sum, 1 + findRoute(newR, newC));
		}
		dp[r][c] = sum;
		return sum;
	}
}
