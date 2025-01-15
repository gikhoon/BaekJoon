import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[][] damage = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};
    static int[][][] memo;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        memo = new int[61][61][61];
        Arrays.sort(arr);
        dfs(arr, 0);
        System.out.println(min);
    }

    private static void dfs(int[] scv, int cnt) {
        if (min <= cnt) {
            return;
        }

        int s1 = scv[0];
        int s2 = scv[1];
        int s3 = scv[2];

        if (memo[s1][s2][s3] != 0 && memo[s1][s2][s3] <= cnt) {
            return;
        }

        memo[s1][s2][s3] = cnt;

        if (s1 == 0 && s2 == 0 && s3 == 0) {
            min = Math.min(min, cnt);
            return;
        }

        for (int i = 0; i < 6; i++) {
            int newS1 = Math.max(s1 + damage[i][0], 0);
            int newS2 = Math.max(s2 + damage[i][1], 0);
            int newS3 = Math.max(s3 + damage[i][2], 0);
            int[] newScv = {newS1, newS2, newS3};
            Arrays.sort(newScv);
            dfs(newScv, cnt+1);
        }
    }
}
