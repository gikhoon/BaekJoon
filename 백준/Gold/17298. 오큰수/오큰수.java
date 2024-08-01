import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
class Node{
    int index;
    int num;

    Node(int index, int num) {
        this.num = num;
        this.index = index;
    }
}
public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        Stack<Node> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if (stack.peek().num < x) {
                    Node pop = stack.pop();
                    answer[pop.index] = x;
                } else {
                    break;
                }
            }
            stack.push(new Node(i, x));
        }

        StringBuilder sb = new StringBuilder();
        for (int num : answer) {
            if (num == 0) sb.append("-1 ");
            else sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
