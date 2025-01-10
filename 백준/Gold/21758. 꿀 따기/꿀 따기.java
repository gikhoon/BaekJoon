import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int MAX;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] map = new int[N];
        int[] sum = new int[N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, map[i]);
            sum[i] = (i == 0 ? map[0] : sum[i - 1] + map[i]);
        }

        //중간에 있을 때
        MAX = sum[N - 1] - map[N - 1] - map[0] + max;

        //제일 오른쪽에 있을 때
        int initLeft = sum[N - 1] - map[0];
        for (int i = 1; i < N - 1; i++) {
            int right = sum[N - 1] - sum[i];
            MAX = Math.max(initLeft - map[i] + right, MAX);
        }

        //제일 왼쪽에 있을 때
        int initRight = sum[N - 2];
        for (int i = 1; i < N - 1; i++) {
            int left = sum[i - 1];
            MAX = Math.max(initRight - map[i] + left, MAX);
        }

        System.out.println(MAX);
    }
}
