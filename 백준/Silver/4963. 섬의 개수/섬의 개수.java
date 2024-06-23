import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;

public class Main {
    static boolean[][] graph;
    static int[] xArray = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] yArray = {-1, 0, 1, 1, -1, -1, 0, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String s = br.readLine();
            if (s.equals("0 0")) {
                break;
            }
            st = new StringTokenizer(s);
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            graph = new boolean[x + 2][y + 2];
            for (int i = 1; i <= x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= y; j++) {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        graph[i][j] = true;
                    }
                }
            }
            int sum = 0;
            for (int i = 1; i <= x; i++) {
                for (int j = 1; j <= y; j++) {
                    if (graph[i][j]) {
                        find(i, j);
                        sum++;
                    }
                }
            }
            System.out.println(sum);
        }
    }

    private static void find(int x, int y) {
        Queue<Integer> xList = new LinkedList<>();
        Queue<Integer> yList = new LinkedList<>();
        xList.offer(x);
        yList.offer(y);
        graph[x][y] = false;
        while (!xList.isEmpty()) {
            Integer currentX = xList.poll();
            Integer currentY = yList.poll();
            for (int i = 0; i < 8; i++) {
                if (graph[currentX + xArray[i]][currentY + yArray[i]]) {
                    graph[currentX + xArray[i]][currentY + yArray[i]] = false;
                    xList.offer(currentX + xArray[i]);
                    yList.offer(currentY + yArray[i]);
                }
            }
        }
    }
}
