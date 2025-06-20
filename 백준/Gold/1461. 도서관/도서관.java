import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>((p1, p2) -> p2 - p1);
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>((p1, p2) -> p2 - p1);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp > 0) {
                positiveQ.offer(temp);
            } else {
                negativeQ.offer(Math.abs(temp));
            }
        }

        int maxV;
        if (positiveQ.isEmpty()) {
            maxV = negativeQ.peek();
        } else if (negativeQ.isEmpty()) {
            maxV = positiveQ.peek();
        } else {
            maxV = Math.max(positiveQ.peek(), negativeQ.peek());
        }


        int ans = 0;
        ans = getLine(M, positiveQ, ans);
        ans = getLine(M, negativeQ, ans);

        ans -= maxV;
        System.out.println(ans);
    }

    private static int getLine(int m, PriorityQueue<Integer> positiveQ, int ans) {
        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();
            for (int i = 0; i < m - 1; i++) {
                positiveQ.poll();

                if (positiveQ.isEmpty()) {
                    break;
                }
            }
            ans += temp * 2;
        }
        return ans;
    }
}