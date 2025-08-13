import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = {-1, 0, 1};
	static int N, M;
	static boolean[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new boolean[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String[] split = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				if (split[j].equals(".")) {
					map[i][j] = true;
				}
			}
		}

		int sum = 0;
		for (int r = 0; r < N; r++) {
			if (dfs(r, 0)) {
				sum++;
			}
		}

		System.out.println(sum);
	}

	static boolean dfs(int r, int c) {
		if (c == M - 1) {
			map[r][c] = false;
			return true;
		}

		boolean isOk = false;
		for (int d = 0; d < 3; d++) {
			if (r + dr[d] < 0 || r + dr[d] >= N)
				continue;
			if (visited[r + dr[d]][c + 1]) {
				continue;
			}

			visited[r][c] = true;
			if (map[r + dr[d]][c + 1]) {
				isOk = dfs(r + dr[d], c + 1);
			}
			if (isOk) {
				map[r][c] = false;
				return true;
			}
		}

		return false;
	}
}
