import java.util.*;
import java.io.*;

public class Main {
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] num = new int[N];
		int maxVal = 0;
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
			maxVal += num[i];
		}
		v = new boolean[maxVal + 1];

		subset(0, N, num, new int[N]);
		int score = 0;
		for (int i = 1; i <= maxVal; i++) {
			if (!v[i])
				score++;
		}
		System.out.println(score);
	}

	public static void subset(int depth, int N, int[] num, int[] answer) {
		if (depth == N) {
			int sum = 0;
			for (int i = 0; i < N; i++) {
				sum += answer[i];
			}
			if (sum <= 0) return; // 합이 음수인 경우는 제외
			v[sum] = true;
			return;
		}

		answer[depth] = num[depth];
		subset(depth + 1, N, num, answer);

		answer[depth] = -num[depth];
		subset(depth + 1, N, num, answer);

		answer[depth] = 0;
		subset(depth + 1, N, num, answer);

	}
}