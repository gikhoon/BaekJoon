import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] data = new int[1_000_002];

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			min = Math.min(min, start);
			max = Math.max(max, end);
			data[start + 1]++;
			data[end + 1]--;
		}

		for (int i = min + 1; i <= max; i++) {
			data[i] += data[i - 1];
		}

		int start = 0;
		int end = 0;

		int sum = 0;
		while (end <= max) {
			if (sum == K) {
				System.out.println(start + " " + end);
				return;
			}

			if (sum < K) {
				end++;
				sum += data[end];
			} else {
				start++;
				sum -= data[start];
			}
		}

		System.out.println("0 0");
		//선분 갯수에 따라 누적합을 구한다?
		//0 -> 0 1 -> 1 ,,,,
		//

		//0 2
		//3 2
		//8 -1
		//10 -2
		//15 -1

		//0 0
		//1 2
		//2 2
		//3 2
		//4 4
		//8 4
		//
	}
}
