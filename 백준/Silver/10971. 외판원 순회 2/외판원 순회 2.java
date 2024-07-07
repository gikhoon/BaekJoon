
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] list;
    static int answer = Integer.MAX_VALUE;
    static boolean[] isVisited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        list = new int[N][N];
        isVisited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                list[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            isVisited[i] = true;
            solve(0, 0, i, i);
            isVisited[i] = false;
        }

        System.out.println(answer);

    }

    static void solve(int depth, int sum, int start, int now) {
        if (answer < sum) {
            return;
        }
        if (depth == N - 1) {
            if (list[now][start] != 0) {
                sum += list[now][start];
                answer = Math.min(sum, answer);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!isVisited[i] && list[now][i] != 0) {
                isVisited[i] = true;
                solve(depth+1,sum+list[now][i],start,i);
                isVisited[i] = false;
            }
        }
    }
}
