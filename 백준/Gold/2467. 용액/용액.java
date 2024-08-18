import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] water;
    static int min = Integer.MAX_VALUE;

    static int[] ret = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        water = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int after0Index = 0;
        for (int i = 0; i < N; i++) {
            water[i] = Integer.parseInt(st.nextToken());
            if (after0Index == 0 && water[i] > 0){ after0Index = i;}
        }

        for (int i = 0; i < N; i++) {
            bisearch(i);
        }

        System.out.println(ret[0] + " " + ret[1]);
    }

    private static void bisearch(int s) {
        int l = s + 1;
        int h = N - 1;
        int mid;

        while (l <= h) {
            mid = (l + h) / 2;
            int tmpSum = water[s] + water[mid];

            if (Math.abs(tmpSum) < min) {
                min = Math.abs(tmpSum);
                ret[0] = water[s];
                ret[1] = water[mid];
            }

            if (tmpSum < 0) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
    }
}
