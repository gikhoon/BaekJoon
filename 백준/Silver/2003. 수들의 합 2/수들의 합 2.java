import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count;

    static int[] list;

    static int M,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken()) + list[i-1];
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int min;
                if (i == 0) {
                    min = 0;
                } else {
                    min = list[i - 1];
                }

                if (list[j] - min == M) answer++;
            }
        }

        System.out.println(answer);
    }
}

