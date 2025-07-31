import java.io.*;
import java.util.*;
import java.util.Stack;

class Building {
	int height;
	int index;

	public Building(int height, int index) {
		this.height = height;
		this.index = index;
	}
}

public class Main {
	static int[] arr;
	static int[] count;
	static int[] index;
	static final int INF = 100000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new int[N];
		count = new int[N];
		index = new int[N];

		Arrays.fill(index, INF);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Stack<Building> s = new Stack<>();
		for(int i=0;i<N;i++) {
			if (s.isEmpty()) {
				s.push(new Building(arr[i],i));
				continue;
			}

			while(!s.isEmpty() && s.peek().height <= arr[i]) {
				s.pop();
			}

			count[i] += s.size();
			if(!s.isEmpty()) {
				index[i] = s.peek().index;
			}
			s.push(new Building(arr[i],i));
		}

		s = new Stack<>();
		for (int i=N-1;i>=0;i--) {
			if (s.isEmpty()) {
				s.push(new Building(arr[i],i));
				continue;
			}

			while(!s.isEmpty() && s.peek().height <= arr[i]) {
				s.pop();
			}

			count[i] += s.size();
			if(!s.isEmpty()) {
				if(Math.abs(i - index[i]) > s.peek().index - i) {
					index[i] = s.peek().index;
				}
			}
			s.push(new Building(arr[i],i));
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(count[i]).append(" ");
			if(count[i] != 0) {
				sb.append(index[i] + 1);
			}
			sb.append("\n");
		}

		System.out.println(sb);

	}

	//7
}
