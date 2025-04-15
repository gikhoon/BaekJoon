import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        if (n == m) {
            System.out.println(1);
            return;
        }

        if (m > n / 2) {
            m = n - m;
        }

        BigInteger answer = BigInteger.ONE;

        for (int i=n;i>n-m;i--) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }

        for (int i=1;i<=m;i++) {
            answer = answer.divide(BigInteger.valueOf(i));
        }

        System.out.println(answer);
    }
}
