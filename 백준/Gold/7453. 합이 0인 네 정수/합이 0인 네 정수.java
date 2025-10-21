import java.io.*;
import java.util.*;

class Main {
	static int[] arr1, arr2;
	static long answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][4];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		arr1 = new int[N * N];
		arr2 = new int[N * N];

		int index= 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr1[index] = arr[i][0] + arr[j][1];
				arr2[index++] = arr[i][2] + arr[j][3];
			}
		}

		Arrays.sort(arr1);
		Arrays.sort(arr2);

		findAnswer();

		System.out.println(answer);

		//N^2 N^2 16_000_000 *
	}

	private static void findAnswer() {
		int start = 0;
		int end = arr2.length - 1;

		while (start < arr1.length && end >= 0) {
			int num1 = arr1[start];
			int num2 = arr2[end];

			if (num1 + num2 == 0) {
				long count1 = 0;
				long count2 = 0;

				while (start < arr1.length && arr1[start] == num1) {
					count1++;
					start++;
				}

				while (end >= 0 && arr2[end] == num2) {
					count2++;
					end--;
				}

				answer += count1 * count2;
			} else if (num1 + num2 > 0) {
				end--;
			} else {
				start++;
			}
		}
	}
}