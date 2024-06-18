import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static String PUSHBACK = "push_back";
    public static String PUSHFRONT = "push_front";
    public static String FRONT = "front";
    public static String BACK = "back";
    public static String SIZE = "size";
    public static String EMPTY = "empty";
    public static String POPFRONT = "pop_front";
    public static String POPBACK = "pop_back";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals(PUSHFRONT)) {
                int number = Integer.parseInt(st.nextToken());
                deque.addFirst(number);
            } else if (command.equals(PUSHBACK)) {
                int number = Integer.parseInt(st.nextToken());
                deque.addLast(number);
            } else if (command.equals(POPFRONT)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollFirst());
                }
            } else if (command.equals(POPBACK)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.pollLast());
                }
            } else if (command.equals(SIZE)) {
                System.out.println(deque.size());
            } else if (command.equals(EMPTY)) {
                if (deque.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals(FRONT)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekFirst());
                }
            } else if (command.equals(BACK)) {
                if (deque.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(deque.peekLast());
                }
            }
        }
    }
}
