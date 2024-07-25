import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        list = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(list);

        int left = 0;
        int right = N - 1;
        int min = Integer.MAX_VALUE;
        int leftMin =0, rightMin=0;

        while (left < right) {
            int x = list[left];
            int y = list[right];

            if (x + y == 0) {
                System.out.println(x + " " + y);
                return;
            } else {
                if (min >= Math.abs(x + y)) {
                    min = Math.abs(x + y);
                    leftMin = x;
                    rightMin = y;
                }

                if (x + y < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(leftMin + " " + rightMin);
    }
}
