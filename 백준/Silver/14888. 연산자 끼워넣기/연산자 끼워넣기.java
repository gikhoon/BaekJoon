import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;
    static int[] operation = new int[4];
    static int[] numbers;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1, numbers[0]);

        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int index, int sum) {
        if (index == N) {
            MIN = Math.min(MIN, sum);
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;

                switch (i) {
                    case 0: dfs(index+1, sum + numbers[index]); break;
                    case 1: dfs(index+1, sum - numbers[index]); break;
                    case 2: dfs(index+1, sum * numbers[index]); break;
                    case 3: dfs(index+1, sum / numbers[index]); break;
                }

                operation[i]++;
            }
        }
    }
}