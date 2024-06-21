import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            color = new int[V + 1];

            graph = new ArrayList<>();
            for (int i = 0; i < V + 1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            boolean isTwo = true;
            for (int i = 1; i < V + 1; i++) {
                if (color[i] == 0) {
                    if (BFS(i)) {
                        isTwo = false;
                        break;
                    }
                }
            }
            if (isTwo) {
                System.out.println("YES");
            }
        }

    }

    static boolean BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        color[v] = 1;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            int currentColor = color[node];

            for (Integer i: graph.get(node)) {
                if (color[i] == currentColor) {
                    System.out.println("NO");
                    return true;
                }
                if (color[i] == 0) {
                    color[i] = currentColor * (-1);
                    queue.offer(i);
                }
            }
        }
        return false;
    }
}
