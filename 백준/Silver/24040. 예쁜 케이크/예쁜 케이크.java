import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			long l = Long.parseLong(br.readLine());
			if ((l % 9 == 0) || (l % 3 == 2)) {
				sb.append("TAK\n");
			} else {
				sb.append("NIE\n");
			}
		}

		System.out.println(sb);
	}
}