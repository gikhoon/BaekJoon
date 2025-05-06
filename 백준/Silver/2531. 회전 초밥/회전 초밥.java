
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static int max;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int total = 0;
        int[] count = new int[d + 1];
        int[] dish = new int[N];

        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            int di = dish[i];
            if (count[di] == 0) total++;
            count[di]++;
        }
        if (count[c] == 0) {
            max = total + 1;
        } else {
            max = total;
        }
        int l = 0;
        int r = k % N;
        while (l < N) {
            int di = dish[l];
            int cou = 0;
            if (count[di] == 1) total--;
            count[di]--;
            di = dish[r];
            if (count[di] == 0) total++;
            count[di]++;
            if (count[c] == 0) {
                cou = 1;
            }

            max = Math.max(max, total+cou);
            l++;
            r = (r + 1) % N;
        }

        System.out.println(max);

    }

    //0 3  4 7, 5 0, 7 2
}
