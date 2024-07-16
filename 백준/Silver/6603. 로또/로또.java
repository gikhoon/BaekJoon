import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            if (K == 0) break;
            int[] s = new int[K];
            boolean[] isVisited = new boolean[K];
            for (int i = 0; i < K; i++) {
                s[i] = Integer.parseInt(st.nextToken());
            }

            findAnswer(s, isVisited, 0, K, 0);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void findAnswer(int[] s, boolean[] isVisited, int depth, int k, int index) {
        if (depth == 6) {
            for (int i = 0; i < k; i++) {
                if (isVisited[i]) {
                    sb.append(s[i]).append(" ");
                }
            }
            sb.append("\n");
            return;
        }

        for (int i = index; i <= k - 6 + depth; i++) {
            isVisited[i] = true;
            findAnswer(s,isVisited, depth+1, k, i+1);
            isVisited[i] = false;
        }
    }
}

