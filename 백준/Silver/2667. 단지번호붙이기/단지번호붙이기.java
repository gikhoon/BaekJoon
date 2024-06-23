import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int[][] graph;
    static int[] xArray = {1, 0, -1, 0};
    static int[] yArray = {0, 1, 0, -1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            String s = br.readLine();
            for (int j = 1; j <= N; j++) {
                char c = s.charAt(j - 1);
                graph[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (graph[i][j] == 1) {
                    list.add(find(i, j));
                }
            }
        }
        System.out.println(list.size());
        list.stream().sorted()
                .forEach(System.out::println);
    }

    private static int find(int x, int y) {
        Queue<Integer> xList = new LinkedList<>();
        Queue<Integer> yList = new LinkedList<>();
        xList.offer(x);
        yList.offer(y);
        graph[x][y] = -1;
        int count = 0;
        while (!xList.isEmpty()) {
            Integer currentX = xList.poll();
            Integer currentY = yList.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                if (graph[currentX + xArray[i]][currentY + yArray[i]] == 1) {
                    graph[currentX + xArray[i]][currentY + yArray[i]] = -1;
                    xList.offer(currentX + xArray[i]);
                    yList.offer(currentY + yArray[i]);
                }
            }
        }
        return count;
    }
}
