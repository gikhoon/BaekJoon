import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] list;

    static int M,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;
        list[0] = Integer.parseInt(st.nextToken());
        if (list[0] == M) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()) + list[i-1];
            if (list[i] >= M) {
                answer = Math.min(answer, i + 1);
            }
        }

        if (Integer.MAX_VALUE == answer) {
            System.out.println(0);
            return;
        }

        for (int i = 1; i < N; i++) {
            for (int j = i; j < N; j++) {
                if (j - i + 1 >= answer) {
                    break;
                }
                if (list[j] - list[i - 1] >= M) {
                    answer = Math.min(answer, j - i + 1);
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}

