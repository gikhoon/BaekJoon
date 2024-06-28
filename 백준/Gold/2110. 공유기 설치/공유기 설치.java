import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {

    static int[] line;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        line = new int[N];
        for (int i = 0; i < N; i++) {
            line[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(line);

        int lo = 1;
        int hi = line[N - 1] - line[0] + 1;

        while (lo < hi) {
            int mid = (hi + lo) / 2;

            if (canInstall(mid) < C) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }

        System.out.println(lo - 1);
    }

    static int canInstall(int dist) {
        int house = 1;
        int lastDist = line[0];

        for (int i = 1; i < line.length; i++) {
            if (line[i] - lastDist >= dist) {
                house++;
                lastDist = line[i];
            }
        }

        return house;
    }
}
