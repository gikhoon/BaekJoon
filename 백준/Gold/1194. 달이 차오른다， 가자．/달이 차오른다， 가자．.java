import java.io.*;
import java.util.*;

class Data {
    int r;
    int c;
    int size;
    int bit;

    public Data(int r, int c, int size, int bit) {
        this.r = r;
        this.c = c;
        this.size = size;
        this.bit = bit;
    }
}

public class Main {
    static char[][] map;
    static int N, M;
    static boolean[][][] isVisited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        isVisited = new boolean[N][M][64];

        Queue<Data> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                if (s.charAt(j) == '0') {
                    Data data = new Data(i, j, 0, 0);
                    q.add(data);
                    map[i][j] = '.';
                    continue;
                }
                map[i][j] = s.charAt(j);
            }
        }

        while(!q.isEmpty()) {
            Data data = q.poll();
            int bit = data.bit;
            for (int d = 0; d < 4; d++) {
                int nR = data.r + dr[d];
                int nC = data.c + dc[d];
                if(!isValid(nR, nC, bit)) continue;
                if(map[nR][nC] == '#') continue;
                if (map[nR][nC] == '1') {
                    System.out.println(data.size + 1);
                    return;
                }
                int key = keyBit(map[nR][nC]);
                if (key == 0) {
                    makeVisitedTrue(nR, nC, bit);
                    q.add(new Data(nR, nC, data.size + 1, data.bit));
                    continue;
                }
                if (key < 0) {
                    makeVisitedTrue(nR, nC, bit);
                    if ((data.bit & (key * -1)) != 0) {
                        q.add(new Data(nR, nC, data.size + 1, data.bit));
                    }
                    continue;
                }
                int newBit = data.bit | key;

                makeVisitedTrue(nR, nC, newBit);
                q.add(new Data(nR, nC, data.size + 1, newBit));
            }
        }

        System.out.println(-1);
    }

    private static boolean isValid(int r, int c, int bit) {
        if(r < 0 || r >= N || c < 0 || c >= M) return false;
        return !isVisited[r][c][bit];
    }

    private static void makeVisitedTrue(int r, int c, int bit) {
        isVisited[r][c][bit] = true;
    }

    private static int keyBit(char data) {
        switch (data) {
            case 'a':
                return 32;
            case 'A':
                return -32;
            case 'b':
                return 16;
            case 'B':
                return -16;
            case 'c':
                return 8;
            case 'C':
                return -8;
            case 'd':
                return 4;
            case 'D':
                return -4;
            case 'e':
                return 2;
            case 'E':
                return -2;
            case 'f':
                return 1;
            case 'F':
                return -1;
            default:
                return 0;
        }
    }

}
