import java.io.*;
import java.util.*;

class Class {
	int start;
	int end;

	public Class(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Class> input = new PriorityQueue<>(Comparator.comparingInt(a -> a.start));
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			input.add(new Class(start, end));
		}

		int classCount = 1;
		PriorityQueue<Class> useClass = new PriorityQueue<>(Comparator.comparingInt(a -> a.end));

		useClass.add(input.poll());

		while(!input.isEmpty()) {
			Class cur = input.poll();
			if (useClass.isEmpty()) {
				useClass.add(cur);
				continue;
			}

			Class lastClass = useClass.peek();
			if(lastClass.end <= cur.start) {
				useClass.poll();
				useClass.add(cur);
				continue;
			}

			if (classCount <= useClass.size()) {
				classCount++;
			}
			useClass.add(cur);
		}

		System.out.println(classCount);
	}
}
