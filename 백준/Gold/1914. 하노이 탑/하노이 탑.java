import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if (N <= 20) {
            hanoi(N, 1, 3);
            System.out.println(count);
            System.out.println(sb);
        } else {
            BigInteger count = new BigInteger("2");
            System.out.println(count.pow(N).subtract(new BigInteger("1")));
        }
    }


    private static void hanoi(int n, int start, int end) {
        if (n == 1) {
            count++;
            sb.append(start).append(" ").append(end).append("\n");
        } else {
            hanoi(n-1,start,findEmpty(start,end));
            sb.append(start).append(" ").append(end).append("\n");
            count++;
            hanoi(n-1,findEmpty(start,end),end);
        }
    }

    private static int findEmpty(int start, int end) {
        for (int i = 1; i <= 3; i++) {
            if (i != start && i != end) {
                return i;
            }
        }
        return -1;
    }
}
