import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if (i == j) continue;
                for (int k = 1; k <= 9; k++) {
                    if (k == j || k == i) continue;
                    queue.add(i * 100 + j * 10 + k);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            if (queue.isEmpty()) {
                System.out.println(0);
                return;
            }

            String[] requestNum = st.nextToken().split("");
            int S = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            Integer firstNum = null;
            while (!queue.isEmpty() && (!queue.peek().equals(firstNum))) {
                Integer number = queue.poll();
                String[] split = String.valueOf(number).split("");

                int s = 0;
                int b = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (requestNum[j].equals(split[k])) {
                            if (j == k) {
                                s++;
                            } else {
                                b++;
                            }
                            break;
                        }
                    }
                }

                if (s == S && b == B) {
                    queue.add(number);
                    if (firstNum == null) {
                        firstNum = number;
                    }
                }
            }
        }

        System.out.println(queue.size());
    }
}

