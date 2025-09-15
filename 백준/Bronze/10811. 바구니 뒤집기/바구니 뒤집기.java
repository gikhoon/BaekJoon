import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] book;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		book = new int[N];

		for (int i = 0; i < N; i++) {
			book[i] = i + 1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			swap(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
		}

		StringBuilder sb = new StringBuilder();
		for (int data : book) {
			sb.append(data + " ");
		}

		System.out.println(sb);
	}

	private static void swap(int start, int end) {
		int[] data = new int[end - start + 1];
		for (int i = 0; i < data.length; i++) {
			data[i] = book[end - i];
		}

		for (int i = start; i <= end; i++) {
			book[i] = data[i-start];
		}
	}

}
