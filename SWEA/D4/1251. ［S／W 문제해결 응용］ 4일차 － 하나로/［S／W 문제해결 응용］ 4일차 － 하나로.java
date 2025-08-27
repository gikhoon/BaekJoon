import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution {
	static int N;
	static double E;
	static int[] x, y;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine().trim());

			x = new int[N];
			y = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				x[i] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++)
				y[i] = Integer.parseInt(st.nextToken());

			E = Double.parseDouble(br.readLine().trim());

			boolean[] visited = new boolean[N];
			long[] minEdge = new long[N];
			Arrays.fill(minEdge, Long.MAX_VALUE);
			minEdge[0] = 0;

			long sumSq = 0;

			for (int i = 0; i < N; i++) {
				long min = Long.MAX_VALUE;
				int u = 0;

				for (int j = 0; j < N; j++) {
					if (!visited[j] && min > minEdge[j]) {
						min = minEdge[j];
						u = j;
					}
				}

				visited[u] = true;
				sumSq += min;

				for (int v = 0; v < N; v++) {
					if (!visited[v]) {
						long w = dist2(u, v);
						if(w < minEdge[v]) {
							minEdge[v] = w;
						}
					}
				}
			}

			System.out.println("#"+test_case+" "+Math.round(sumSq * E));
		}


	}

	private static long dist2(int i, int j) {
		long dx = (long) x[i] - x[j];
		long dy = (long) y[i] - y[j];
		return dx * dx + dy * dy;
	}
}