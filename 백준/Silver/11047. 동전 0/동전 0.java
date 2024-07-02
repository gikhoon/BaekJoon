
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Stack<Integer> coinList = new Stack<>();
        for (int i = 0; i < N; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }

        int sum = 0;
        while (K > 0) {
            if (coinList.peek() > K) coinList.pop();
            else {
                int count = K / coinList.peek();
                K -= coinList.peek() * count;
                sum += count;
            }
        }

        System.out.println(sum);
    }
}
