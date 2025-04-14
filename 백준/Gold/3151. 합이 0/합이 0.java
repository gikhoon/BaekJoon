import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] map;         // 각 코딩 실력의 빈도수를 저장할 배열
    static final int INDEX = 10000;  // 오프셋 (코딩 실력이 음수이므로)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        map = new int[20001];  // -10000 ~ 10000 까지의 값을 저장하기 위해

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            map[num + INDEX]++;
        }

        long answer = 0;

        // i, j, k에 해당하는 인덱스를 이용한 순회 (i <= j <= k)
        for (int i = 0; i <= 20000; i++) {
            if (map[i] == 0) continue;
            int a = i - INDEX;  // 실제 코딩 실력 값

            for (int j = i; j <= 20000; j++) {
                if (map[j] == 0) continue;
                int b = j - INDEX;

                // a + b + c = 0  ->  c = -(a+b)
                int c = -(a + b);
                int k = c + INDEX;  // c에 해당하는 배열 인덱스

                if (k < j || k > 20000) continue;
                if (map[k] == 0) continue;

                // 세 수의 종류에 따라 경우의 수 계산
                if (i == j && j == k) {
                    answer += ((long) map[i] * (map[i] - 1) * (map[i] - 2)) / 6;
                } else if (i == j) {
                    answer += (((long) map[i] * (map[i] - 1)) / 2) * map[k];
                } else if (j == k) {
                    answer += map[i] * (((long) map[j] * (map[j] - 1)) / 2);
                } else {
                    answer += (long) map[i] * map[j] * map[k];
                }
            }
        }

        System.out.println(answer);
    }
}
