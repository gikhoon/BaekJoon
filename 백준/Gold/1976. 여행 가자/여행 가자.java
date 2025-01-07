import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    unionRoot(i, j);
                }
            }
        }
        st = new StringTokenizer(br.readLine());
        int start = findRoot(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int nowRoot = findRoot(Integer.parseInt(st.nextToken()));

            if (nowRoot != start) {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }

    static void unionRoot(int x, int y) {
        x = findRoot(x);
        y = findRoot(y);

        if (x != y) {
            parent[x] = y;
        }
    }

    static int findRoot(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = findRoot(parent[x]);
    }
}
