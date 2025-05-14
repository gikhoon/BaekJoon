import java.util.*;
import java.io.*;
public class Main {
    static int N, M;
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            Node findNode = findNode(num);

            if (findNode == null) {
                if (nodes.size() >= N) {
                    Node deleteNode = findMinNode();
                    nodes.remove(deleteNode);
                }
                nodes.add(new Node(num, 1, i));
                //없을 시
            } else {
                //있을 시
                findNode.count++;
            }
        }

        List<Integer> answers = new ArrayList<>();
        for (Node node : nodes) {
            answers.add(node.num);
        }
        Collections.sort(answers);

        StringBuilder sb = new StringBuilder();
        for (int num : answers) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

    private static Node findMinNode() {
        Node minMode = nodes.get(0);
        for (Node node : nodes) {
            if (minMode.count > node.count) {
                minMode = node;
            }
            if (minMode.count == node.count && minMode.index > node.index) {
                minMode = node;
            }
        }
        return minMode;
    }

    private static Node findNode(int num) {
        for (Node node : nodes) {
            if (node.num == num) {
                return node;
            }
        }
        return null;
    }
}

class Node {
    int num;
    int count;
    int index;

    public Node(int num, int count, int index) {
        this.num = num;
        this.count = count;
        this.index = index;
    }
}