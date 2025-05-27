import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int nextIndex = 1;

        while (nextIndex < N) {
            int needK =  arr[nextIndex] - arr[nextIndex-1];
            if (needK * nextIndex > K) {
                System.out.println(arr[nextIndex-1] + K / nextIndex);
                return;
            }
            K -= (needK * nextIndex);
            nextIndex++;
        }

        System.out.println(arr[nextIndex-1] + K / N);
    }
}
