import java.io.*;
import java.util.*;

public class Main {
	static int[][] map;
	static final int MAX = 1_000_000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			Arrays.fill(map[i], MAX);
			map[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			map[x][y] = v;
			map[y][x] = v;
		}

		//최소 거리 셋팅
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				if(k==i) continue;
				for (int j = 1; j <= N; j++) {
					if(i==j || j == k) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		int min = Integer.MAX_VALUE;
		int index = -1;

		for (int i = 1; i <= N; i++) {
			int sum = 0;
			for (int j = 1; j <= N; j++) {
				sum += map[i][j];
			}
			if (sum < min) {
				min = sum;
				index = i;
			}
		}

		System.out.println(index);

	}
}
