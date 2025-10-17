import java.io.*;
import java.util.*;
class Lecture {
	int cost;
	int d;

	public Lecture(int cost, int d) {
		this.cost = cost;
		this.d = d;
	}
}

class Main {


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Lecture> waitQ = new PriorityQueue<>((o1,o2) -> o2.d - o1.d);
		PriorityQueue<Lecture> canLectureQ = new PriorityQueue<>(((o1, o2) -> o2.cost - o1.cost));
		StringTokenizer st;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			waitQ.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		if (waitQ.isEmpty()) {
			System.out.println(0);
			return;
		}
		int cur = waitQ.peek().d;

		int sum = 0;
		while (cur > 0) {
			while (!waitQ.isEmpty() && waitQ.peek().d == cur) {
				canLectureQ.add(waitQ.poll());
			}
			if (!canLectureQ.isEmpty()) {
				sum += canLectureQ.poll().cost;
			}
			cur--;
		}

		System.out.println(sum);
	}
}