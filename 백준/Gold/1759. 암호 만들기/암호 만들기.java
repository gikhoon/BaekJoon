import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int L;
    static String[] list;

    static int C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new String[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            list[i] = st.nextToken();
        }

        Arrays.sort(list);


        dfs(0, 0, "");

        System.out.println(sb);
    }

    private static void dfs(int depth, int index, String answer) {
        if (depth == L) {
            boolean isAEIOU = false;
            int count = 0;

            for (int i = 0; i < answer.length(); i++) {
                char c = answer.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    isAEIOU = true;
                } else {
                    count++;
                }
            }

            if (isAEIOU && (count > 1)) {
                sb.append(answer).append("\n");
            }
            return;
        }

        for (int i = index; i <= C - L + depth; i++) {
            dfs(depth+1, i+1, answer+list[i]);
        }
    }
}

