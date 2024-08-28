import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static boolean[][] isVisited;
    static int N, M;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            year++;
            map = meltIce();
            int land = isSeparate();
            if (land == 0) {
                System.out.println(0);
                return;
            }
            if(land == 2){
                break;
            }
        }

        System.out.println(year);
    }

    private static int isSeparate() {
        isVisited = new boolean[N][M];
        int land = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && map[i][j] > 0) {
                    if (land != 0) return 2;
                    land++;
                    checkLand(i, j);
                }
            }
        }

        return land;
    }

    private static void checkLand(int i, int j) {
        isVisited[i][j] = true;
        Queue<Integer> xq = new LinkedList<>();
        Queue<Integer> yq = new LinkedList<>();
        xq.add(i);
        yq.add(j);
        while (!xq.isEmpty()) {
            Integer x = xq.poll();
            Integer y = yq.poll();
            for (int d = 0; d < 4; d++) {
                int newX = x + dx[d];
                int newY = y + dy[d];
                if (!isVisited[newX][newY] && map[newX][newY] > 0) {
                    isVisited[newX][newY] = true;
                    xq.add(newX);
                    yq.add(newY);
                }
            }
        }
    }

    private static int[][] meltIce() {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    int ice = map[i][j];
                    for (int d = 0; d < 4; d++) {
                        if (map[i - dx[d]][j - dy[d]] == 0) ice--;
                        if (ice == 0) break;
                    }
                    newMap[i][j] = ice;
                }
            }
        }

        return newMap;
    }
}
