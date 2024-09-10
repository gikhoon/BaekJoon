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

        for (int i = 0; i < M; i++) {
            Arrays.fill(bee[i], 1);
        }

        for (int d = 0; d < N; d++) {
            st = new StringTokenizer(br.readLine());
            int RIndex = M - 1;
            int CIndex = 1;
            for (int i = 0; i < 3; i++) {
                int count = Integer.parseInt(st.nextToken());
                while (RIndex >= 0 && count > 0) {
                    bee[RIndex][0] += i;
                    RIndex--;
                    count--;
                }

                while (count > 0) {
                    for (int r = 0; r < M; r++) {
                        bee[r][CIndex] += i;
                    }
                    CIndex++;
                    count--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(bee[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}