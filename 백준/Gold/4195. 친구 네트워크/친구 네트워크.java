import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int MAX = 0;
    static Map<String, Integer> count = new HashMap<>();
    static Map<String, String> parent = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            count.clear();
            parent.clear();
            MAX = 0;
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                unionRoot(st.nextToken(), st.nextToken());
            }
        }
        System.out.println(sb);
    }

    static void unionRoot(String x, String y) {
        x = findRoot(x);
        y = findRoot(y);

        if (!x.equals(y)) {
            parent.put(x, y);
            int countX = count.getOrDefault(x, 1);
            count.put(y, countX + count.getOrDefault(y, 1));
            sb.append(count.get(y)).append("\n");
        } else {
            sb.append(count.get(y)).append("\n");
        }

    }

    static String findRoot(String x) {
        if (!parent.containsKey(x)) {
            parent.put(x, x);
            return x;
        }
        if (parent.get(x).equals(x)) {
            return x;
        }
        String root = findRoot(parent.get(x));
        parent.put(x, root);
        return root;
    }
}
