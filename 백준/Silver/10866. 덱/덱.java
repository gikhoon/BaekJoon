import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

    static class Deque {
        private Node head;
        private Node tail;
        private int size;

        public void pushFront(Node node) {
            if (0 == size) {
                head = node;
                tail = node;
            } else {
                head.before = node;
                node.next = head;
                head = node;
            }
            size++;
        }

        public void pushBack(Node node) {
            if (0 == size) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.before = tail;
                tail = node;
            }
            size++;
        }

        public void popFront() {
            if (0 == size) {
                System.out.println(-1);
                return;
            } else if (1 == size) {
                System.out.println(head.number);
                head = null;
                tail = null;
            } else {
                System.out.println(head.number);
                head = head.next;
            }
            size--;
        }

        public void popBack() {
            if (0 == size) {
                System.out.println(-1);
                return;
            } else if (1 == size) {
                System.out.println(tail.number);
                head = null;
                tail = null;
            } else {
                System.out.println(tail.number);
                tail = tail.before;
            }
            size--;
        }

        public void front() {
            if (0 == size) {
                System.out.println(-1);
            } else {
                System.out.println(head.number);
            }
        }

        public void back() {
            if (0 == size) {
                System.out.println(-1);
            } else {
                System.out.println(tail.number);
            }
        }

        public void size() {
            System.out.println(size);
        }

        public void empty() {
            if (0 == size) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    static class Node {
        private int number;
        private Node next;
        private Node before;

        public Node(int number) {
            this.number = number;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque deque = new Deque();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals(PUSHFRONT)) {
                int number = Integer.parseInt(st.nextToken());
                deque.pushFront(new Node(number));
            } else if (command.equals(PUSHBACK)) {
                int number = Integer.parseInt(st.nextToken());
                deque.pushBack(new Node(number));
            } else if (command.equals(FRONT)) {
                deque.front();
            } else if (command.equals(BACK)) {
                deque.back();
            } else if (command.equals(SIZE)) {
                deque.size();
            } else if (command.equals(EMPTY)) {
                deque.empty();
            } else if (command.equals(POPFRONT)) {
                deque.popFront();
            } else if (command.equals(POPBACK)) {
                deque.popBack();
            }
        }
    }
}
