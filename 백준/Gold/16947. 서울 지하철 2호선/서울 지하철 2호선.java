import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer>[] links;
	static int N;
	static boolean[] visited;
	static int[] ans;
	static Queue<Integer> q = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		links = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			links[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			links[x].add(y);
			links[y].add(x);
		}

		ans = new int[N+1];
		Arrays.fill(ans, -1);
		for(int i = 1; i <= N; i++) {
			visited = new boolean[N+1];
			checkCircular(i,1,i);
		}

		bfs();

		StringBuilder sb = new StringBuilder();
		for(int i=1;i<=N;i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);

	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int u = q.poll();

			for(int next : links[u]) {
				if (ans[next] == -1) {
					ans[next] = ans[u] + 1;
					q.offer(next);
				}
			}
		}
	}

	private static void checkCircular(int cur, int cnt, int start) {
		visited[cur] = true;

		for(int next : links[cur]) {
			if(!visited[next]) checkCircular(next, cnt+1, start);
			else if (next == start && cnt >= 3) {
				ans[next] = 0;
				q.offer(next);
				return;
			}
		}
	}
}
