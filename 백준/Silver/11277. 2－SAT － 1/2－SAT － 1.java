import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n, m;
	private static boolean[] variable;
	private static int[][] clause;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		variable = new boolean[n+1];
		clause = new int[m][2];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 2; j++) clause[i][j] = Integer.parseInt(st.nextToken());
		}

		System.out.println(bruteForce(0));
		br.close();
	}
	
	private static boolean getVariable(int v) {
		if (v > 0) return variable[v];
		else return !variable[-v];
	}
	
	private static int bruteForce(int v) {
		variable[v] = true;
		if (check() == 1) return 1;
		
		for (int i = v+1; i < n+1; i++) {
			if (bruteForce(i) == 1) return 1;
		}
		variable[v] = false;
		return 0;
	}
	
	private static int check() {
		for (int i = 0; i < m; i++) {
			if ((getVariable(clause[i][0]) || getVariable(clause[i][1])) == false) return 0;
		}
		return 1;
	}
}