import java.io.*;
import java.util.*;
class Rock {
    int x;
    int y;

    public Rock(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object obj) {
        Rock node = (Rock) obj;
        return node.x == x && node.y == y;
    }
}

class Node {
    int x;
    int y;
    int size;

    public Node(int x, int y, int size) {
        this.x = x;
        this.y = y;
        this.size =size;
    }
}

public class Main {
    //set에 50000개를 넣고 찾기 25번 찾기 이미 사용한건 빼기
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<Rock> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            set.add(new Rock(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.y == M) {
                System.out.println(cur.size);
                return;
            }

            for (int i = cur.x - 2; i <= cur.x + 2; i++) {
                for (int j = cur.y - 2; j <= cur.y + 2; j++) {
                    Rock newRock = new Rock(i, j);
                    if (set.contains(newRock)) {
                        q.add(new Node(newRock.x, newRock.y, cur.size + 1));
                        set.remove(newRock);
                    }
                }
            }
        }

        System.out.println(-1);
    }
}
