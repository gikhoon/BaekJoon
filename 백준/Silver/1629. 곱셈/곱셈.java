import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(power(A, B, C));
    }

    private static long power(int a, int b, int c) {
        if (b == 1) {
            return a % c;
        }
        if (b == 0) {
            return 1;
        }
        long answer = power(a, b / 2, c) % c;
        answer = (answer * answer) % c;
        if (b % 2 == 1) {
            answer = (answer * a) % c;
        }
        return answer;
    }
}