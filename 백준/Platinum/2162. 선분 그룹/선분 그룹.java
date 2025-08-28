import java.io.*;
import java.util.*;

class Line2 {
	double x1;
	double y1;
	double x2;
	double y2;

	public Line2(double x1, double y1, double x2, double y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
}

public class Main {
	static Line2[] lines;
	static int[] parents;
	static int[] count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		lines = new Line2[N];

		StringTokenizer st;

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x1 = Double.parseDouble(st.nextToken());
			double y1 = Double.parseDouble(st.nextToken());
			double x2 = Double.parseDouble(st.nextToken());
			double y2 = Double.parseDouble(st.nextToken());
			lines[i] = new Line2(x1, y1, x2, y2);
		}

		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (int i = 0; i < N; i++) {
			for (int j = i+1; j < N; j++) {
				//두 선분이 겹치면 union
				if (isIntersecting(lines[i], lines[j])) {
					union(i, j);
				}
			}
		}

		count = new int[N];

		// 그룹의 수 계산
		int groups = 0;
		int max = 0;
		for (int i = 0; i < N; i++) {
			int root = find(i);
			if(count[root] == 0) groups++;
			count[root]++;
			max = Math.max(max, count[root]);
		}

		System.out.println(groups);
		System.out.println(max);
	}

	// CCW 알고리즘: 세 점의 방향성을 확인
	private static int ccw(double x1, double y1, double x2, double y2, double x3, double y3) {
		double result = (x2 - x1) * (y3 - y1) - (y2 - y1) * (x3 - x1);
		if (result > 0) return 1;   // 반시계방향
		if (result < 0) return -1;  // 시계방향
		return 0;                   // 일직선
	}

	// 두 선분이 교차하는지 확인
	private static boolean isIntersecting(Line2 line1, Line2 line2) {
		int ccw1 = ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x1, line2.y1);
		int ccw2 = ccw(line1.x1, line1.y1, line1.x2, line1.y2, line2.x2, line2.y2);
		int ccw3 = ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x1, line1.y1);
		int ccw4 = ccw(line2.x1, line2.y1, line2.x2, line2.y2, line1.x2, line1.y2);

		// 일반적인 교차 케이스
		if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0) {
			return true;
		}

		// 한 선분의 끝점이 다른 선분 위에 있는 경우
		if (ccw1 == 0 && isOnSegment(line1, line2.x1, line2.y1)) return true;
		if (ccw2 == 0 && isOnSegment(line1, line2.x2, line2.y2)) return true;
		if (ccw3 == 0 && isOnSegment(line2, line1.x1, line1.y1)) return true;
		if (ccw4 == 0 && isOnSegment(line2, line1.x2, line1.y2)) return true;

		return false;
	}

	// 점이 선분 위에 있는지 확인
	private static boolean isOnSegment(Line2 line, double px, double py) {
		return Math.min(line.x1, line.x2) <= px && px <= Math.max(line.x1, line.x2) &&
			   Math.min(line.y1, line.y2) <= py && py <= Math.max(line.y1, line.y2);
	}

	private static int find(int a) {
		if (parents[a] == a) {
			return a;
		}

		return parents[a] = find(parents[a]);
	}

	private static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);

		parents[root1] = root2;
	}
}
