
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E = Integer.parseInt(st.nextToken()) % 15;
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken()) % 19;

        while (true) {
            if (S % 15 == E && S % 19 == M) {
                System.out.println(S);
                break;
            }
            S += 28;
        }
    }
}
