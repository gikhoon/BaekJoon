import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            graph = new int[N + 1];
            boolean[] isVisited = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                graph[i] = Integer.parseInt(st.nextToken());
            }

            int circularCycle = 0;
            for (int i = 1; i <= N; i++) {
                int next = i;
                while (!isVisited[next]) {
                    isVisited[next] = true;
                    if (graph[next] == i) {
                        circularCycle++;
                    }
                    next = graph[next];
                }
            }

            System.out.println(circularCycle);

        }
    }
}
