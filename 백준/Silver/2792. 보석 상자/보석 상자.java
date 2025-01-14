import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[M];
        int min = 1, max = 0, mid;
        int answer = 0,sum;

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        while(min <= max) {
            mid = (min + max) / 2;
            sum = 0;
            for (int i = 0; i < M; i++) {
                sum += arr[i] / mid;
                if (arr[i] % mid != 0) {
                    sum++;
                }
            }
            if (sum > N) {
                min = mid + 1;
            } else {
                max = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
