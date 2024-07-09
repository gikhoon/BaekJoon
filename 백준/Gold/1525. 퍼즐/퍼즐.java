import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    String list;
    int count;

    Node(String list, int count) {
        this.list = list;
        this.count = count;
    }
}

public class Main {
    static Set<String> visitedList = new HashSet<>();
    static String answer = "123456780";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String initList = "";
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                initList = initList.concat(st.nextToken());
            }
        }

        Queue<Node> queue = new LinkedList<>();
        if (initList.equals(answer)) {
            System.out.println(0);
            return;
        }
        queue.add(new Node(initList, 0));
        visitedList.add(initList);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            String order = node.list;
            int indexOf0 = order.indexOf("0");

            if (indexOf0 % 3 != 0) {
                String newOrder = order.replace('0', '9');
                char c = newOrder.charAt(indexOf0 - 1);
                String replace = swap(c, newOrder);
                if (replace.equals(answer)) {
                    System.out.println(node.count + 1);
                    return;
                }

                if (!visitedList.contains(replace)) {
                    visitedList.add(replace);
                    queue.add(new Node(replace, node.count + 1));
                }
            }

            if (indexOf0 - 3 >= 0) {
                String newOrder = order.replace('0', '9');
                char c = newOrder.charAt(indexOf0 - 3);
                String replace = swap(c, newOrder);
                if (replace.equals(answer)) {
                    System.out.println(node.count + 1);
                    return;
                }

                if (!visitedList.contains(replace)) {
                    visitedList.add(replace);
                    queue.add(new Node(replace, node.count + 1));
                }
            }

            if (indexOf0 % 3 != 2) {
                String newOrder = order.replace('0', '9');
                char c = newOrder.charAt(indexOf0 + 1);
                String replace = swap(c, newOrder);
                if (replace.equals(answer)) {
                    System.out.println(node.count + 1);
                    return;
                }

                if (!visitedList.contains(replace)) {
                    visitedList.add(replace);
                    queue.add(new Node(replace, node.count + 1));
                }
            }

            if (indexOf0 + 3 < 9) {
                String newOrder = order.replace('0', '9');
                char c = newOrder.charAt(indexOf0 + 3);
                String replace = swap(c, newOrder);
                if (replace.equals(answer)) {
                    System.out.println(node.count + 1);
                    return;
                }

                if (!visitedList.contains(replace)) {
                    visitedList.add(replace);
                    queue.add(new Node(replace, node.count + 1));
                }
            }
        }

        System.out.println(-1);
    }

    public static String swap (char c, String order){
        return order.replace(c, '0').replace('9', c);
    }
}

