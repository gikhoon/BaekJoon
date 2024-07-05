
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] num = new int[N][M];
        int[] row = new int[N];
        int[] col = new int[M];

        long answer = 0;

        for (int i = 0; i < N; i++) {
            String[] nums = br.readLine().split("");
            int sum = 0;
            for (int j = 0; j < M; j++) {
                num[i][j] = Integer.parseInt(nums[j]);
                sum += num[i][j];
            }
            row[i] = sum;
        }

        for (int i = 0; i < M; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += num[j][i];
            }
            col[i] = sum;
        }

        if (N >= 3) {
            int a = 0;
            int b;
            int c;
            for (int i = 1; i < N - 1; i++) {
                a += row[i - 1];
                b = 0;
                c = 0;
                for (int k = i; k < N; k++) {
                    c += row[k];
                }
                for (int j = i + 1; j < N; j++) {
                    b += row[j - 1];
                    c -= row[j - 1];
                    answer = Math.max((long) a * b * c, answer);
                }
            }
        }

        if (M >= 3) {
            int a = 0;
            int b;
            int c;
            for (int i = 1; i < M - 1; i++) {
                a += col[i - 1];
                b = 0;
                c = 0;
                for (int k = i; k < M; k++) {
                    c += col[k];
                }
                for (int j = i + 1; j < M; j++) {
                    b += col[j - 1];
                    c -= col[j - 1];
                    answer = Math.max((long) a * b * c, answer);
                }
            }
        }

        if (M >= 2 && N >= 2) {
            int a, b, c, d;
            for (int i = 1; i < N; i++) {
                a = 0;
                c = 0;
                b = 0;
                d = 0;
                for (int k = 0; k < i; k++) {
                    b += row[k];
                }
                for (int k = i; k < N; k++) {
                    d += row[k];
                }
                for (int j = 1; j < M; j++) {
                    for (int k = 0; k < i; k++) {
                        a += num[k][j - 1];
                        b -= num[k][j - 1];
                    }
                    for (int k = i; k < N; k++) {
                        c += num[k][j - 1];
                        d -= num[k][j - 1];
                    }
                    answer = Math.max((long) (a + b) * c * d, answer);
                    answer = Math.max((long) (a + c) * b * d, answer);
                    answer = Math.max((long) (b + d) * a * c, answer);
                    answer = Math.max((long) (c + d) * a * b, answer);
                }
            }
        }

        System.out.println(answer);
    }
}
