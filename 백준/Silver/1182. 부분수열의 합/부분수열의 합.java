import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count;

    static int[] list;

    static int S,N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        list = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        findAnswer(0,0,0);

        System.out.println(count);
    }

    private static void findAnswer(int index, int answer, int total) {
        if (answer == S && total > 0) {
            count++;
        }

        if (index >= N) return;

        if (answer > S && list[index] > 0) {
            return;
        }

        for (int i = index; i < N; i++) {
            total++;
            findAnswer(i+1, answer+list[i], total);
            total--;
        }
    }
}

