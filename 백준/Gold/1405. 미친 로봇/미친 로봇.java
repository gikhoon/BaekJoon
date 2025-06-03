import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N;
    static boolean[][] isVisited = new boolean[30][30];
    static double[] percentage = new double[4];
    static double answer = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i < 4; i++) {
            percentage[i] = Integer.parseInt(st.nextToken()) * 0.01;
        }

        isVisited[15][15] = true;
        DFS(15, 15, 0, 1);

        System.out.println(answer);
    }

    private static void DFS(int x, int y, int index, double result) {
        if (index == N) {
            answer += result;
            return;
        }

        for (int d = 0; d < 4; d++) {
            int newX = x + dx[d];
            int newY = y + dy[d];

            if (isVisited[newX][newY]) {
                continue;
            }

            isVisited[newX][newY] = true;
            DFS(newX, newY, index + 1, result * percentage[d]);
            isVisited[newX][newY] = false;
        }


    }
}
