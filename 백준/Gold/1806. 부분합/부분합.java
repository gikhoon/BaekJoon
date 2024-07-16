import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] list;

    static int S,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        int answer = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0; int len = 0;
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            sum += list[i];
            if (sum >= S) {
                while (sum - list[start] >= S && start < i) {
                    sum -= list[start++];
                }
                len = i - start + 1;
                if (len == 1) {
                    System.out.println(1);
                    return;
                }
                if (len < answer) {
                    answer = len;
                }
//                sum -= list[start++];
            }
        }

        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}

