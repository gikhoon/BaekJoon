import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
    int x1;
    int y1;
    int x2;
    int y2;

    Node(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public boolean isNodeTouching(Queue<Node> nodeList) {
        for (Node node : nodeList) {
            if (this.isNodeTouching(node)) {
                return true;
            }
        }
        return false;
    }

    public boolean isNodeTouching(Node node) {
        // 사각형이 겹치는지 확인합니다.
        if (this.x1 < node.x1 && node.x2 < this.x2 && this.y1 < node.y1 && node.y2 < this.y2) {
            return false;
        }

        if (this.x1 > node.x1 && node.x2 > this.x2 && this.y1 > node.y1 && node.y2 > this.y2) {
            return false;
        }

        if (this.x2 < node.x1 || this.x1 > node.x2 || this.y2 < node.y1 || this.y1 > node.y2) {
            return false;
        }

        return true;

    }

    public boolean isNodeTouch00() {
        return y1 == 0 && x1 * x2 <= 0 || y2 == 0 && x1 * x2 <= 0 || x1 == 0 && y1 * y2 <= 0 || x2 == 0 && y1 * y2 <= 0;
    }
}
public class Main {

    /**
     * 사각형이 서로 겹쳐져 있으면 가능하다. 맞닿아 있어도 괜찮아요~ 하나씩 사각형을 받는다. 0 관련 항목이 있는지 체크하는 boolean 값 하나 필요 LinkedList를 돌면서 겹치는 지 확인 안
     * 겹치면 새 List에 넣는다. 겹치는 항목들은 한 항목에 넣는다.
     */
    static List<Queue<Node>> nodeList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        boolean isInitPUNecessary = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Node newNode = new Node(Math.min(x1, x2), Math.min(y1, y2), Math.max(x1, x2), Math.max(y1, y2));
            Queue<Node> rootNode = null;
            for (Queue<Node> nodes : nodeList) {
                if (newNode.isNodeTouching(nodes)) {
                    if (rootNode == null) {
                        rootNode = nodes;
                    } else {
                        while (!nodes.isEmpty()) {
                            rootNode.add(nodes.poll());
                        }
                    }
                }
            }

            if (rootNode == null) {
                Queue<Node> queue = new LinkedList<>();
                queue.add(newNode);
                nodeList.add(queue);
            } else {
                rootNode.add(newNode);
            }

            if (isInitPUNecessary && newNode.isNodeTouch00()) {
                isInitPUNecessary = false;
            }
        }

        int answer = 0;
        for (Queue<Node> node : nodeList) {
            if (!node.isEmpty()) {
                answer++;
            }
         }


        if (!isInitPUNecessary) {
            System.out.println(answer - 1);
        } else {
            System.out.println(answer);
        }
    }
}
