import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Node{
    int floor;
    int count;

    Node(int floor, int count) {
        this.floor = floor;
        this.count = count;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[F+1];
        isVisited[0] = true;
        isVisited[S] = true;

        if (S == G) {
            System.out.println(0);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(S, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            int newUpFloor = currentNode.floor + U;
            int newDownFloor = currentNode.floor - D;

            if (newUpFloor == G || newDownFloor == G) {
                System.out.println(currentNode.count + 1);
                return;
            }

            if (isFloorValid(newUpFloor, F) && !isVisited[newUpFloor]) {
                queue.add(new Node(newUpFloor, currentNode.count + 1));
                isVisited[newUpFloor] = true;
            }

            if (isFloorValid(newDownFloor, F) && !isVisited[newDownFloor]) {
                queue.add(new Node(newDownFloor, currentNode.count + 1));
                isVisited[newDownFloor] = true;
            }
        }

        System.out.println("use the stairs");
    }

    private static boolean isFloorValid(int floor, int max) {
        return floor <= max && floor > 0;
    }
}
