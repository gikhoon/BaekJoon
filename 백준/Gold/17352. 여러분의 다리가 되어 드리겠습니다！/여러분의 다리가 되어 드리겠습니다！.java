import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a, b);
        }

        int data1 = 0, data2 = 0;
        for (int i = 1; i <= N; i++) {
            if (parent[i] == i) {
                if (data1 == 0) {
                    data1 = i;
                } else {
                    data2 = i;
                    break;
                }
            }
        }

        System.out.println(data1 + " " + data2);
    }

    static void union(int a, int b) {
        a = findRoot(a);
        b = findRoot(b);

        if (a != b) {
            parent[b] = a;
        }
    }

    static int findRoot(int a) {
        if (parent[a] == a) {
            return a;
        }

        return parent[a] = findRoot(parent[a]);
    }
}
