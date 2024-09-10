import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] bee;
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        bee = new int[M][M];
        int[] add = new int[2 * M - 1];

        for (int i = 0; i < M; i++) {
            Arrays.fill(bee[i], 1);
        }

        for (int d = 0; d < N; d++) {
            st = new StringTokenizer(br.readLine());
            int index = 0;
            for (int i = 0; i < 3; i++) {
                int count = Integer.parseInt(st.nextToken());
                while (count > 0) {
                    add[index] += i;
                    index++;
                    count--;
                }
            }
        }

        int index = 0;
        for (int i = M - 1; i >= 0; i--) {
            bee[i][0] += add[index];
            index++;
        }

        for (int i = 1; i < M; i++) {
            bee[0][i] += add[index];
            index++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(bee[i][0]).append(" ");
            for (int j = 1; j < M; j++) {
                sb.append(bee[0][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}