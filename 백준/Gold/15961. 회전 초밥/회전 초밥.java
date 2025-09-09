import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dish;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 종류 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹은 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰 번호

        dish = new int[N];
        count = new int[d + 1];
        int total = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < k; i++) {
            if (count[dish[i]] == 0) {
                total++;
            }
            count[dish[i]]++;
        }

        if (count[c] == 0) {
            max = total + 1;
        } else {
            max = total;
        }

        //0 ~ 5 k=6 6을 더하고 0을 빼
        for (int start = 0; start < N; start++) {
            int end = (start + k) % N;

            if (count[dish[start]] == 1) {
                total--;
            }
            count[dish[start]]--;

            if (count[dish[end]] == 0) {
                total++;
            }
            count[dish[end]]++;

            if (count[c] == 0) {
                max = Math.max(max, total + 1);
            } else {
                max = Math.max(max, total);
            }
        }

        System.out.println(max);
    }
}
