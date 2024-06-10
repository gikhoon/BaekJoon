package BaekJoon11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        int[] upDp = new int[N + 1];
        int[] downDp = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        upDp[1] = 1;
        downDp[N] = 1;

        for (int i = 2; i < N + 1; i++) {
            upDp[i] = 1;
            for (int j = i - 1; j > 0; j--) {
                if ((arr[i] > arr[j]) && upDp[i] < upDp[j] + 1) {
                    upDp[i] = upDp[j] + 1;
                }
            }
        }

        for (int i = N - 1; i > 0; i--) {
            downDp[i] = 1;
            for (int j = N; j > i; j--) {
                if ((arr[i] > arr[j]) && downDp[i] < downDp[j] + 1) {
                    downDp[i] = downDp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i < N + 1; i++) {
            max = Math.max(max, upDp[i] + downDp[i]);
        }

        System.out.println(max - 1);
    }
}
