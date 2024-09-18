import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int M, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int gcd = Integer.parseInt(st.nextToken());
        int lcd = Integer.parseInt(st.nextToken());

        long mul = (long) gcd * lcd;

        int a = 0, b = 0;

        for (int i = gcd; i <= Math.sqrt(mul); i += gcd) {
            if (mul % i == 0 && euclidean(i, mul / i) == gcd) {
                a = i;
                b = (int) (mul / i);
            }
        }

        System.out.println(a + " " + b);
    }

    private static long euclidean(long a, long b) {
        long r = a % b;
        if (r == 0) {
            return b;
        }

        return euclidean(b, r);
    }
}