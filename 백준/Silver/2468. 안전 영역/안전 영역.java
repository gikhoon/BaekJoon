import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int[][] map;

    static int N;

    static boolean[][] isVisited;

    static int[] rVal = {0, 0, 1, -1};
    static int[] cVal = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        map = new int[N + 2][N + 2];
        int min = 101;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int n = Integer.parseInt(st.nextToken());
                min = Math.min(min, n);
                map[i][j] = n;
            }
        }

        int maxArea = 1;
        for (int i = min; i <= 100; i++) {
            maxArea = Math.max(findArea(map, i), maxArea);
        }

        System.out.println(maxArea);
    }

    private static int findArea(int[][] map, int depth) {
        isVisited = new boolean[N + 2][N + 2];
        int land = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (!isVisited[i][j] && map[i][j] > depth) {
                    findLand(i, j, depth);
                    land++;
                }
            }
        }

        return land;
    }

    private static void findLand(int i, int j, int depth) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> cQueue = new LinkedList<>();
        isVisited[i][j] = true;
        rQueue.add(i);
        cQueue.add(j);
        while (!rQueue.isEmpty()) {
            int r = rQueue.poll();
            int c = cQueue.poll();

            for (int val = 0; val < 4; val++) {
                int newR = r + rVal[val];
                int newC = c + cVal[val];
                if (!isVisited[newR][newC] && map[newR][newC] > depth) {
                    isVisited[newR][newC] = true;
                    rQueue.add(newR);
                    cQueue.add(newC);
                }
            }
        }
    }
}

