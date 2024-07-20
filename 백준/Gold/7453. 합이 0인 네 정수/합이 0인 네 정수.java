import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static long count;

    static int[] A, B, C, D;

    static int N;

    static int[] AB, CD;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        B = new int[N];
        C = new int[N];
        D = new int[N];
        AB = new int[N * N];
        CD = new int[N * N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                AB[idx] = A[i] + B[j];
                CD[idx++] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        findAnswer();

        System.out.println(count);
    }


    /**
     * 4000 * 4000 * 2 = 16_000_000 * 2 * 2
     */
    private static void findAnswer() {
        int pointL = 0;
        int pointR = CD.length - 1;
        while (pointL < AB.length && pointR >= 0) {
            int valL = AB[pointL];
            int valR = CD[pointR];

            if (valL + valR == 0) {
                long cntL = 0;
                long cntR = 0;

                while (pointL < AB.length && valL == AB[pointL]) {
                    cntL++;
                    pointL++;
                }

                while (pointR >= 0 && valR == CD[pointR]) {
                    cntR++;
                    pointR--;
                }

                count += cntL * cntR;
            }
            else if (valL + valR < 0) {
                pointL++;
            }
            else {
                pointR--;
            }
        }

    }
}
