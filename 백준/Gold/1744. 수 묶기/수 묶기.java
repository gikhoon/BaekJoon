import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    /**
     * 0 이하가 홀수 일 때
     * 큰거끼로 곱해서 더해 ===> 한개가 남았을 때 하나 앞이 0이 있으면 곱하고 아니면 더함
     * 그 뒤 양수들 홀수면 맨 앞 더하고 아니면 다 곱함
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> before0 = new PriorityQueue<>();
        PriorityQueue<Integer> after1 = new PriorityQueue<>();
        boolean is0Exist = false;


        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 0) {
                after1.add(num);
            } else if (num < 0)
                before0.add(num);
            else {
                is0Exist = true;
            }
        }
        int sum = 0;
        while (before0.size() > 1) {
            sum += before0.poll() * before0.poll();
        }

        if (!before0.isEmpty() && !is0Exist) {
            sum += before0.poll();
        }

        if (after1.size() % 2 == 1) {
            sum += after1.poll();
        }

        while (!after1.isEmpty()) {
            Integer num1 = after1.poll();
            Integer num2 = after1.poll();
            if (num1 != 1) {
                sum += num1 * num2;
            } else {
                sum += num1;
                sum += num2;
            }
        }

        System.out.println(sum);

    }
}
