import java.util.*;
import java.io.*;
class Node {
	int r;
	int c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class Solution {
	static int N;
	static Node[] nodes;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			nodes = new Node[N * N + 1];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int size = Integer.parseInt(st.nextToken());
					nodes[size] = new Node(i, j);
				}
			}

			int max = 1;
			int maxIndex = 1;
			int start = 1;
			int end = 2;
			while (end <= N * N) {
				if(isNear(nodes[end-1], nodes[end])){
					end++;
				} else {
					if(max < end - start) {
						max = end - start;
						maxIndex = start;
					}
					start = end;
					end++;
				}
			}

			if (isNear(nodes[end - 2], nodes[end - 1])) {
				if (max < end - start) {
					max = end - start;
					maxIndex = start;
				}
			}

			System.out.println("#" + test_case + " " + maxIndex + " " + max);
		}
	}

	private static boolean isNear(Node n1, Node n2) {
		return (Math.abs(n1.r - n2.r) + Math.abs(n1.c - n2.c) == 1);
	}
}