import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		arr = new int[L];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (n == arr[i]) {
				System.out.println(0);
				return;
			}
		}

		Arrays.sort(arr);
		int a = 0;
		int b = 0;

		for (int i = 0; i < L; i++) {
			if (arr[i] > n) {
				b = arr[i];
				if (i==0) a = 0;
				else a = arr[i - 1];
				break;
			}
		}

		if (a == 0) {
			a = n;
		} else {
			a = n - a;
		}
		b = b - n - 1;

		System.out.println(a - 1 + (a * b));

	}
}
