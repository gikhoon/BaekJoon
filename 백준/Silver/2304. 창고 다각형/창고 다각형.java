
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int start;
    int end;

    public Node(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Building {
    int x;
    int y;

    public Building(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static List<Node> nodes = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Building> q = new PriorityQueue<>((o1, o2) -> o2.y - o1.y);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            q.add(new Building(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;
        Building building = q.poll();
        nodes.add(new Node(building.x, building.x));
        answer += building.y;

        while (!q.isEmpty()) {
            Building current = q.poll();
            if (isExist(current.x)) continue;
            int near = near(current.x);
            answer += current.y * (Math.abs(current.x - near));
            nodes.add(new Node(Math.min(near, current.x), Math.max(near, current.x)));
        }

        System.out.println(answer);
    }

    private static boolean isExist(int x) {
        for (Node node : nodes) {
            if (node.start <= x && node.end >= x) {
                return true;
            }
        }
        return false;
    }

    private static int near(int x) {
        int index = 10000;
        for (Node node : nodes) {
            if (Math.abs(index - x) > Math.abs(node.start - x)) {
                index = node.start;
            }
            if (Math.abs(index - x) > Math.abs(node.end - x)) {
                index = node.end;
            }
        }
        return index;
    }
}
