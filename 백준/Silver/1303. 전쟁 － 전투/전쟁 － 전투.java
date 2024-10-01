import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean[][] map;
    static boolean[][] isVisited;
    static int N,M;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if(split[j].equals("B")) map[i][j] = true;
            }
        }

        int white = 0;
        int blue = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(!isVisited[i][j]){
                    if (map[i][j]) {
                        blue += bfs(i, j);
                    } else {
                        white += bfs(i, j);
                    }
                }
            }
        }

        System.out.println(white + " " + blue);
    }

    private static int bfs(int i, int j) {
        int count = 0;
        Queue<Integer> rq = new LinkedList<>();
        Queue<Integer> cq = new LinkedList<>();
        rq.add(i);
        cq.add(j);
        isVisited[i][j] = true;

        while (!rq.isEmpty()) {
            Integer r = rq.poll();
            Integer c = cq.poll();
            count++;
            for (int d = 0; d < 4; d++) {
                int newR = r + dr[d];
                int newC = c + dc[d];
                if (valid(newR, M) && valid(newC, N)) {
                    if (!isVisited[newR][newC] && map[newR][newC] == map[r][c]) {
                        isVisited[newR][newC] = true;
                        rq.add(newR);
                        cq.add(newC);
                    }
                }
            }
        }

        return count * count;
    }

    private static boolean valid(int index, int max) {
        return index >= 0 && index < max;
    }
}