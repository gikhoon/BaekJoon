import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);

        count[0] = 1;
        int maxCount = 1;
        long maxValue = arr[0];
        for (int i = 1; i < N; i++) {
            count[i] = 1;
            if (arr[i - 1] == arr[i]) {
                count[i] = count[i - 1] + 1;
            }
            if (count[i] > maxCount) {
                maxCount = count[i];
                maxValue = arr[i];
            }
        }

        System.out.println(maxValue);
    }
}
