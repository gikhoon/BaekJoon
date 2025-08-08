import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static ArrayList<Integer>[] link;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		link = new ArrayList[N + 1];
		for(int i=1; i <= N; i++) {
			link[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			link[B].add(A);
			link[A].add(B);
		}

		boolean[] visited = new boolean[N + 1];
		List<Integer> list = new ArrayList<>();
		int count = 0;
		visited[1] = true;

		for (int next : link[1]) {
			visited[next] = true;
			list.add(next);
			count++;
		}

		for (int next : list) {
			for(int nextNext : link[next]) {
				if(!visited[nextNext]) {
					visited[nextNext] = true;
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
