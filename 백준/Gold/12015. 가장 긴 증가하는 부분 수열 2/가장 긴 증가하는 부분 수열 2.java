import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int lastIndex = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());

            if (lastIndex < 0 || list[lastIndex] < x) {
                lastIndex++;
                list[lastIndex] = x;
            } else {
                int index = findIndex(0, lastIndex, x, list);
                list[index] = x;
            }
        }

        System.out.println(lastIndex + 1);
    }

    private static int findIndex(int left, int right, int x, int[] list) {
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] < x) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
