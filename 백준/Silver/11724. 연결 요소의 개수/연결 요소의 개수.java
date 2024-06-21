import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static boolean[][] graph;
    public static int N;
    public static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new boolean[N + 1][N + 1];
        isUsed = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = true;
            graph[y][x] = true;
        }
        int connectedComponent = 0;
        for (int i = 1; i <= N; i++) {
            if (!isUsed[i]) {
                connectedComponent++;
                DFS(i);
            }
        }

        System.out.println(connectedComponent);
    }

    static void DFS(int v) {
        Stack<Integer> stack = new Stack<>();
        stack.push(v);

        while (!stack.isEmpty()) {
            Integer node = stack.peek();
            if (!isUsed[node]) {
                isUsed[node] = true;
            }
            boolean isConnected = false;
            for (int i = 1; i < N + 1; i++) {
                if (!isUsed[i] && graph[node][i]) {
                    stack.push(i);
                    isConnected = true;
                    break;
                }
            }
            if (!isConnected) {
                stack.pop();
            }
        }
    }
}
