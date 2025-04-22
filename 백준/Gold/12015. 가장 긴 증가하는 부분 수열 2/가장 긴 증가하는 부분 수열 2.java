import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] list = new int[N];
        int lastIndex = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (lastIndex < 0 || list[lastIndex] < n) {
                lastIndex++;
                list[lastIndex] = n;
                continue;
            }

            int index = findIndex(lastIndex, n, list);
            list[index] = n;
        }

        System.out.println(lastIndex+1);
    }

    private static int findIndex(int lastIndex, int num, int[] list) {
        int left = 0;
        int right = lastIndex;
        while (left < right) {
            int mid = (left + right) / 2;
            if (list[mid] < num) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}
