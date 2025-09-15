import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node {
	int end;
	int weight;

	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

public class Main {
	static int[] dist;
	static boolean[] isVisited;
	static ArrayList<Node>[] links;
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		links = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			links[i] = new ArrayList<>();
		}

		dist = new int[N + 1];
		isVisited = new boolean[N + 1];
		Arrays.fill(dist, INF);

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			links[a].add(new Node(b, w));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		for (Node n : links[start]) {
			dist[n.end] = Math.min(dist[n.end], n.weight);
		}

		isVisited[start] = true;
		dist[start] = 0;

		while (true) {
			int nextIndex = shortest();
			if (nextIndex == -1) {
				break;
			}
			isVisited[nextIndex] = true;

			for (Node next : links[nextIndex]) {
				dist[next.end] = Math.min(dist[next.end], dist[nextIndex] + next.weight);
			}

			if (nextIndex == end) {
				break;
			}
		}

		if (dist[end] == INF) {
			System.out.println(-1);
		} else {
			System.out.println(dist[end]);
		}

	}

	private static int shortest() {
		int minIndex = -1;
		for (int i = 1; i < dist.length; i++) {
			if(isVisited[i]) continue;
			if (minIndex == -1) {
				minIndex = i;
				continue;
			}
			if (dist[minIndex] > dist[i]) {
				minIndex = i;
			}
		}
		return minIndex;
	}

}
