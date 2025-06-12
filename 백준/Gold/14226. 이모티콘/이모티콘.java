import java.io.*;
import java.util.*;

class Node {
    int num;
    int clip;
    int count;

    public Node(int num, int clip, int count) {
        this.num = num;
        this.clip = clip;
        this.count = count;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[][] isVisit = new boolean[4000][4000];
        Queue<Node> q = new LinkedList<>();

        q.add(new Node(1, 0, 0));
        isVisit[1][0] = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.num == N) {
                System.out.println(cur.count);
                return;
            }

            if (cur.num > N) {
                q.add(new Node(cur.num - 1, 0, cur.count + 1));
                continue;
            }

            if (!isVisit[cur.num][cur.num]) {
                isVisit[cur.num][cur.num] = true;
                q.add(new Node(cur.num, cur.num, cur.count + 1));
            }

            if (!isVisit[cur.num + cur.clip][cur.clip]) {
                isVisit[cur.num + cur.clip][cur.clip] = true;
                q.add(new Node(cur.num + cur.clip, cur.clip, cur.count + 1));
            }

            if (cur.num > 1 && !isVisit[cur.num - 1][cur.clip]) {
                isVisit[cur.num - 1][cur.clip] = true;
                q.add(new Node(cur.num - 1, cur.clip, cur.count + 1));
            }
        }
    }
}
