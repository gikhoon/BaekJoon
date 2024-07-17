import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    static int answer = 0;

    static boolean[] isPrime;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        isPrime = new boolean[N + 1];
        Arrays.fill(isPrime, true);

        isPrime[0] = false;
        isPrime[1] = false;



        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j = j + i) {
                    isPrime[j] = false;
                }
            }
        }

        int sum = 0;
        int start = 0;
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                sum += i;
                while (sum >= N && start <= i) {
                    if (sum == N) {
                        answer++;
                        break;
                    }

                    if (isPrime[start]) {
                        sum -= start;
                    }
                    start++;
                }
            }
        }

        System.out.println(answer);
    }
}

