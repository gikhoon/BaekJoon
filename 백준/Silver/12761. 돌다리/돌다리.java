import java.io.*;
import java.util.*;

class Node {
    int n;
    int c;

    public Node(int n, int c) {
        this.n = n;
        this.c = c;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        boolean[] isVisited = new boolean[100001];
        isVisited[0] = true;
        isVisited[start] = true;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));

        while (!q.isEmpty()) {
            Node cur = q.poll();
            int curN = cur.n;
            if (cur.n == end) {
                System.out.println(cur.c);
                return;
            }
            if (isOk(curN + 1) && !isVisited[curN + 1]) {
                isVisited[curN + 1] = true;
                q.add(new Node(curN + 1, cur.c + 1));
            }
            if (isOk(curN - 1) && !isVisited[curN - 1]) {
                isVisited[curN - 1] = true;
                q.add(new Node(curN - 1, cur.c + 1));
            }
            if (isOk(curN + A) && !isVisited[curN + A]) {
                isVisited[curN + A] = true;
                q.add(new Node(curN + A, cur.c + 1));
            }
            if (isOk(curN + B) && !isVisited[curN + B]) {
                isVisited[curN + B] = true;
                q.add(new Node(curN + B, cur.c + 1));
            }
            if (isOk(curN - A) && !isVisited[curN - A]) {
                isVisited[curN - A] = true;
                q.add(new Node(curN - A, cur.c + 1));
            }
            if (isOk(curN - B) && !isVisited[curN - B]) {
                isVisited[curN - B] = true;
                q.add(new Node(curN - B, cur.c + 1));
            }
            if (isOk(curN * A) && !isVisited[curN * A]) {
                isVisited[curN * A] = true;
                q.add(new Node(curN * A, cur.c + 1));
            }
            if (isOk(curN * B) && !isVisited[curN * B]) {
                isVisited[curN * B] = true;
                q.add(new Node(curN * B, cur.c + 1));
            }
        }
    }

    private static boolean isOk(int i) {
        return i > 0 && i <= 100000;
    }
}
