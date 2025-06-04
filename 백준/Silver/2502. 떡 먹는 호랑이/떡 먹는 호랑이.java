import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[D];
        arr[D - 1] = K;

        for (int i = K; i >= K - K / 2; i--) {
            boolean isOk = true;
            arr[D - 2] = i;
            arr[D - 3] = K - i;
            if (arr[D - 3] < 1 || arr[D - 3] > arr[D - 2]) {
                continue;
            }

            for (int index = D - 4; index >= 0; index--) {
                arr[index] = arr[index + 2] - arr[index + 1];
                if (arr[index] < 1 || arr[index] > arr[index + 1]) {
                    isOk = false;
                    break;
                }
            }

            if (isOk) {
                System.out.println(arr[0]);
                System.out.println(arr[1]);
                break;
            }
        }
    }

    //2 26 28 54 82 136 218
}
