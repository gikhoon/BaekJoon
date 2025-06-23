import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve());
    }

    private static int solve() {
        int result = 0;
        int left = 0;
        int right = N-1;

        while (left < right) {
            result = Math.max((right - left - 1) * Math.min(arr[left], arr[right]), result);
            if (arr[left] < arr[right]) {
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}