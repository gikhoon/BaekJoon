import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static Set<Integer>[] graph;
    static int N;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new Set[N + M + 1];
        visited = new int[N + M + 1];

        for (int i = 1; i <= N + M; i++) {
            graph[i] = new HashSet<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int hyperTube = N + 1 + i;
            for (int j = 0; j < K; j++) {
                int connect = Integer.parseInt(st.nextToken());
                graph[hyperTube].add(connect);
                graph[connect].add(hyperTube);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = 1;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == N) {
                System.out.println(visited[num]);
                return;
            }
            for (int connect : graph[num]) {
                if (visited[connect] == 0) {
                    if (connect <= N) {
                        visited[connect] = visited[num] + 1;
                    } else {
                        visited[connect] = visited[num];
                    }

                    q.offer(connect);
                }
            }
        }

        System.out.println(-1);
    }
}