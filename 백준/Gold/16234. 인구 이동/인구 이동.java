import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int L, R, N;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static HashMap<Integer, Integer> total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int c;
        for (c=0;c<=2000;c++) {
            visited = new boolean[N][N];
            int[][] union = new int[N][N];
            total = new HashMap<>();
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        count++;
                        getMap(i, j, count, union);
                    }
                }
            }
            if (count == N * N) {
                break;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = total.get(union[i][j]);
                }
            }
        }

        System.out.println(c);
    }

    private static void getMap(int r, int c, int num, int[][] union) {
        Queue<Integer> rowQ = new LinkedList<>();
        Queue<Integer> colQ = new LinkedList<>();
        visited[r][c] = true;
        rowQ.add(r);
        colQ.add(c);
        int count = 0;
        int sum = 0;
        while (!rowQ.isEmpty()) {
            int row = rowQ.poll();
            int col = colQ.poll();
            union[row][col] = num;
            count++;
            int currentPerson = map[row][col];
            sum += currentPerson;
            for (int i = 0; i < 4; i++) {
                int nr = row + dr[i];
                int nc = col + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc]) {
                    continue;
                }
                if (Math.abs(currentPerson - map[nr][nc]) >= L && Math.abs(currentPerson - map[nr][nc]) <= R) {
                    rowQ.add(nr);
                    colQ.add(nc);
                    visited[nr][nc] = true;
                }
            }
        }

        total.put(num, sum / count);
    }
}
