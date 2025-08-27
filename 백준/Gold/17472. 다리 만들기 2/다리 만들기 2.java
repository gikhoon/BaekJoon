import java.io.*;
import java.util.*;

class Land {
	int r;
	int c;

	public Land(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

class Dist implements Comparable<Dist> {
	int s;
	int e;
	int weight;

	public Dist(int s, int e, int weight) {
		this.s = s;
		this.e = e;
		this.weight = weight;
	}

	@Override
	public int compareTo(Dist d) {
		return this.weight - d.weight;
	}
}

public class Main {
	static int[] parent;
	static int[][] map;
	static int[][] dist;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static final int INF = 1000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int landName = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1) {
					findLand(i, j, landName++);
				}
			}
		}

		dist = new int[landName][landName];
		for (int i = 0; i < landName; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != 0) {
					calDist(i, j);
				}
			}
		}

		parent = new int[landName];
		for (int i = 0; i < landName; i++) {
			parent[i] = i;
		}

		PriorityQueue<Dist> q = new PriorityQueue<>();
		for(int i = 2;i<landName;i++){
			for(int j = i+1;j<landName;j++){
				if (dist[i][j] != INF && dist[i][j] != 0) {
					q.add(new Dist(i, j, dist[i][j]));
				}
			}
		}

		int sum = 0;
		int edgeCount = 0;

		while (!q.isEmpty()) {
			Dist d = q.poll();
			if(!union(d.e, d.s)) continue;
			edgeCount++;
			sum += d.weight;
		}

		if (edgeCount < landName - 3) {
			System.out.println(-1);
		} else {
			System.out.println(sum);
		}


		//크루스칼 알고리즘
	}

	private static int findRoot(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = findRoot(parent[a]);
	}

	private static boolean union(int a, int b) {
		int rootA = findRoot(a);
		int rootB = findRoot(b);

		if (rootA == rootB)
			return false;

		parent[rootA] = rootB;
		return true;
	}

	private static void calDist(int r, int c) {
		int land = map[r][c];

		for (int d = 0; d < 4; d++) {
			int a = 1;
			while (true) {
				int newR = r + dr[d] * a;
				int newC = c + dc[d] * a;
				if (newR < 0 || newR >= map.length || newC < 0 || newC >= map[0].length)
					break;
				if (map[newR][newC] == land)
					break;
				if (map[newR][newC] != 0) {
					if (a == 2)
						break;
					dist[land][map[newR][newC]] = Math.min(a - 1, dist[land][map[newR][newC]]);
					break;
				}
				a++;
			}
		}
	}

	private static void findLand(int r, int c, int landName) {
		Queue<Land> q = new LinkedList<>();
		q.add(new Land(r, c));
		map[r][c] = landName;

		while (!q.isEmpty()) {
			Land l = q.poll();
			for (int d = 0; d < 4; d++) {
				int newR = l.r + dr[d];
				int newC = l.c + dc[d];
				if (newR < 0 || newR >= map.length || newC < 0 || newC >= map[0].length)
					continue;
				if (map[newR][newC] == 1) {
					q.add(new Land(newR, newC));
					map[newR][newC] = landName;
				}
			}
		}
	}
}
