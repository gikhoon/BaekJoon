import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] link;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int LENGTH = 1000;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            findLink(N);

            boolean[] visited = new boolean[N + 2];
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            visited[0] = true;

            boolean isLinked = false;
            while(!q.isEmpty()) {
                int cur = q.poll();
                if(isLinked) break;
                for (int next : link[cur]) {
                    if (next == N + 1) {
                        isLinked = true;
                        break;
                    }
                    if(visited[next]) continue;
                    visited[next] = true;
                    q.add(next);
                }
            }

            if(isLinked) {
                sb.append("happy\n");
            } else {
                sb.append("sad\n");
            }
        }

        System.out.println(sb);
    }

    private static void findLink(int houses) throws IOException {
        StringTokenizer st;
        link = new ArrayList[houses + 2];
        int[][] map = new int[houses + 2][2];
        for (int i = 0; i < houses + 2; i++) {
            link[i] = new ArrayList<>();
            st = new  StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (isLinked(map[i], map[j])) {
                    link[i].add(j);
                    link[j].add(i);
                }
            }
        }
    }

    private static boolean isLinked(int[] h1, int[] h2) {
        return (Math.abs(h1[0] - h2[0]) + Math.abs(h1[1] - h2[1]) <= LENGTH);
    }
}
