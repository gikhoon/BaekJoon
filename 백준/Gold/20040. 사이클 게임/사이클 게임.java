import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		for (int round = 1; round <= M; round++) {
			st = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			if(!union(node1, node2)) {
				System.out.println(round);
				return;
			}
		}

		System.out.println(0);
	}

	private static int find(int node) {
		if (node == parent[node]) {
			return node;
		}
		parent[node] = find(parent[node]);
		return parent[node];
	}

	private static boolean union(int node1, int node2) {
		int root1 = find(node1);
		int root2 = find(node2);

		if (root1 == root2) {
			return false;
		}

		parent[root1] = root2;
		return true;
	}
}
