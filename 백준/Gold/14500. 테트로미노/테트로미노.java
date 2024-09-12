import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m - 2; j++) {
                getAnswer23(i, j);
            }
        }

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 1; j++) {
                getAnswer32(i, j);
            }
        }

        for (int i = 0; i < n - 3; i++) {
            for (int j = 0; j < m; j++) {
                int size = 0;
                for (int k = 0; k < 4; k++) {
                    size += map[i + k][j];
                }
                MAX = Math.max(MAX, size);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 3; j++) {
                int size = 0;
                for (int k = 0; k < 4; k++) {
                    size += map[i][j + k];
                }
                MAX = Math.max(MAX, size);
            }
        }

        System.out.println(MAX);
    }

    private static void getAnswer23(int r, int c) {
        int size = 0;
        for (int i = r; i < r + 2; i++) {
            for (int j = c; j < c + 3; j++) {
                size += map[i][j];
            }
        }

        boolean[][] isVisit = new boolean[2][3];
        for (int i = r; i < r + 2; i++) {
            for (int j = c; j < c + 3; j++) {
                isVisit[i - r][j - c] = true;
                for (int i2 = r; i2 < r + 2; i2++) {
                    for (int j2 = c; j2 < c + 3; j2++) {
                        if (!isVisit[i2 - r][j2 - c] && canUse23(i - r, j - c, i2 - r, j2 - c)) {
                            if (size - map[i][j] - map[i2][j2] > MAX) {
                                MAX = Math.max(MAX, size - map[i][j] - map[i2][j2]);
                            }
                        }
                    }
                }
                isVisit[i - r][j - c] = false;
            }
        }
    }

    private static void getAnswer32(int r, int c) {
        int size = 0;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 2; j++) {
                size += map[i][j];
            }
        }

        boolean[][] isVisit = new boolean[3][2];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 2; j++) {
                isVisit[i - r][j - c] = true;
                for (int i2 = r; i2 < r + 3; i2++) {
                    for (int j2 = c; j2 < c + 2; j2++) {
                        if (!isVisit[i2 - r][j2 - c] && canUse23(j - c, i - r, j2 - c, i2 - r)) {
                            if (size - map[i][j] - map[i2][j2] > MAX) {
                                MAX = Math.max(MAX, size - map[i][j] - map[i2][j2]);
                            }
                        }
                    }
                }
                isVisit[i - r][j - c] = false;
            }
        }
    }

    static boolean canUse23(int r1, int c1, int r2, int c2) {
        if (c1 == 1) {
            return r1 == r2;
        }
        if (r1 == 0) {
            return !(r2 == 1 && c2 == 1);
        }
        return !(r2 == 0 && c2 == 1);
    }
}