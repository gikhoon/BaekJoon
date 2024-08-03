import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import javax.security.auth.login.AccountNotFoundException;

class Node {
    int num;
    int weight;

    Node(int num, int weight) {
        this.num = num;
        this.weight = weight;
    }
}

public class Main {

    static int[][] answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        answer = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            Arrays.fill(answer[i], Integer.MAX_VALUE / 2);
            answer[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            answer[from][to] = Math.min(answer[from][to], weight);
        }

        for (int mid = 1; mid <= n; mid++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    answer[i][j] = Math.min(answer[i][j], answer[i][mid] + answer[mid][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (answer[i][j] == Integer.MAX_VALUE / 2) {
                    answer[i][j] = 0;
                }
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}

