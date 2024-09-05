import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.SortedMap;
import java.util.StringTokenizer;

class Counsel {
    int days;
    int pay;

    public Counsel(int days, int pay) {
        this.days = days;
        this.pay = pay;
    }
}

public class Main {
    static Counsel[] counsels;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1];

        counsels = new Counsel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            counsels[i] = new Counsel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i=N-1; i>=0; i--) {
            if (i + counsels[i].days - 1 < N) {
                dp[i] = Math.max(dp[i+ counsels[i].days] + counsels[i].pay, dp[i+1]);
            } else {
                dp[i] = dp[i+1];
            }
        }

        System.out.println(dp[0]);
    }
}