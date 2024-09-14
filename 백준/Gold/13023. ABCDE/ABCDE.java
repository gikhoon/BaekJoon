import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {
    static List<Integer>[] graph;
    static int N;
    static boolean answer = false;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);

        }

        for (int i = 0; i < N; i++) {
            visited[i] = true;
            DFS(i, 0);
            if (answer) {
                System.out.println(1);
                return;
            }
            visited[i] = false;
        }

        System.out.println(0);

    }

    private static void DFS(int current, int count) {
        if (count == 4) {
            answer = true;
            return;
        }

        for (Integer v : graph[current]) {
            if (!visited[v]) {
                visited[v] = true;
                DFS(v, count + 1);
                if (answer) {
                    return;
                }
                visited[v] = false;
            }
        }
    }
}