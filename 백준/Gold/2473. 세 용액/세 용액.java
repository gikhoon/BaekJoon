import java.io.*;
import java.util.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] liquid = new int[N];
		long MIN = Long.MAX_VALUE;
		int[] answer = new int[3];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(st.nextToken());
		}
		//하나 선택하고 -> 투 포인터

		Arrays.sort(liquid);
		for (int i = 0; i < N - 2; i++) {
			if (MIN == 0) {
				break;
			}
			if (liquid[i] > 0) {
				long sum =  (long) liquid[i] + liquid[i + 1] + liquid[i + 2];
				if (Math.abs(sum) < MIN) {
					MIN = Math.abs(sum);
					answer[0] = liquid[i];
					answer[1] = liquid[i + 1];
					answer[2] = liquid[i + 2];
				}
				break;
			}

			int start = i + 1;
			int end = N - 1;

			while (start < end) {
				long sum = (long) liquid[i] + liquid[start] + liquid[end];
				if (Math.abs(sum) < MIN) {
					MIN = Math.abs(sum);
					answer[0] = liquid[i];
					answer[1] = liquid[start];
					answer[2] = liquid[end];
				}
				if (sum == 0) {
					break;
				} else if (sum < 0) {
					start++;
				} else {
					end--;
				}
			}
		}

		System.out.println(answer[0] + " " + answer[1] + " " + answer[2]);
	}
}