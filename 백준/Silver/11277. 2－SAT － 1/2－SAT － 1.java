import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static boolean[] comb;
    static Pair[] pairs;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        comb = new boolean[n + 1];
        pairs = new Pair[m + 1];

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            pairs[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        recur(0);

        bw.write("0");
        bw.flush();
    }

    private static void recur(int depth) throws IOException {
        if (depth == n + 1) {
            boolean flag = true;
            for (int i = 1; i <= m; i++) {
                boolean left = pairs[i].left < 0 ? !comb[-pairs[i].left] : comb[pairs[i].left];
                boolean right = pairs[i].right < 0 ? !comb[-pairs[i].right] : comb[pairs[i].right];

                flag = flag && (left || right);
            }

            if (flag)
                bw.write("1");
            else
                return;

            bw.flush();
            System.exit(0);
        }

        for (int i = 0; i < 2; i++) {
            comb[depth] = i == 0 ? true : false;
            recur(depth + 1);
        }
    }

    private static class Pair {
        int left, right;

        public Pair(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

}