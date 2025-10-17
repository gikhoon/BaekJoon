import java.io.*;
import java.util.*;

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for(int t=0;t<T;t++) {
			int N = Integer.parseInt(br.readLine());
			sb.append(N / 2 + 1).append("\n");
			PriorityQueue<Integer> before = new PriorityQueue<>((o1,o2) -> o2 - o1);
			PriorityQueue<Integer> after = new PriorityQueue<>();
			StringTokenizer st;

			st = new StringTokenizer(br.readLine());
			int mid = Integer.parseInt(st.nextToken());

			sb.append(mid + " ");
			int count = 1;
			for (int i = 1; i < N; i++) {
				if (!st.hasMoreTokens()) {
					st = new StringTokenizer(br.readLine());
				}

				int cur = Integer.parseInt(st.nextToken());
				if (mid > cur) {
					before.add(cur);
				} else {
					after.add(cur);
				}

				if (i % 2 == 0) {
					if (before.size() > after.size()) {
						after.add(mid);
						mid = before.poll();
					} else if (before.size() < after.size()) {
						before.add(mid);
						mid = after.poll();
					}

					sb.append(mid + " ");
					count++;
					if (count % 10 == 0 && i != N-1) {
						sb.append("\n");
					}
				}
			}

			sb.append("\n");


		}
		System.out.println(sb);
	}
}