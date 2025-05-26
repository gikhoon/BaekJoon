import java.io.*;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int totalSheep = 0;
    static int totalWolf = 0;
    static boolean[][] isVisited;
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        isVisited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    calculate(i, j);
                }
            }
        }

        System.out.println(totalSheep + " " + totalWolf);

    }

    private static void calculate(int r, int c) {
        Queue<Integer> qr = new LinkedList<>();
        Queue<Integer> qc = new LinkedList<>();
        int sheep = 0;
        int wolf = 0;
        qr.add(r);
        qc.add(c);
        isVisited[r][c] = true;

        while (!qr.isEmpty()) {
            int curR = qr.poll();
            int curC = qc.poll();
            if(map[curR][curC] == 'v') wolf++;
            if(map[curR][curC] == 'k') sheep++;

            for (int d = 0; d < 4; d++) {
                int newR = curR + dr[d];
                int newC = curC + dc[d];

                if (newR < 0 || newR >= map.length || newC < 0 || newC >= map[0].length) continue;

                if (!isVisited[newR][newC] && map[newR][newC] != '#') {
                    qr.add(newR);
                    qc.add(newC);
                    isVisited[newR][newC] = true;
                }
            }
        }

        if(sheep > wolf) totalSheep += sheep;
        else totalWolf += wolf;
    }
}
