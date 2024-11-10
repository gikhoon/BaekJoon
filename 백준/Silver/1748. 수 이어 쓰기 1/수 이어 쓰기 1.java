import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		int mul = 10;
		int num = 1;

		for (int i = 1; i <= n; i++) {
			if (i % mul == 0) {
				num++;
				mul *= 10;
			}
			answer += num;
		}
		System.out.println(answer);
	}
}