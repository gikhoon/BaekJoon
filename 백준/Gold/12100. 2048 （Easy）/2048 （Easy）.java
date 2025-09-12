import java.io.IOException;
import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int N;
    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                MAX = Math.max(MAX, map[i][j]);
            }
        }

        backTracking(0, MAX);
        System.out.println(MAX);
    }

    private static void backTracking(int count, int max) {
        if (count == 5) return;
        if (!isValid(count, max)) {
            return;
        }
        int[][] tmp = cpArr(map);
        for (int i = 0; i < 4; i++) {
            int newMax = simulation(i, max);
            MAX = Math.max(MAX, newMax);
            backTracking(count + 1, newMax);
            map = tmp;
        }

    }

    private static boolean isValid(int count, int max) {
        return (int) Math.pow(2, 5 - count) * max > MAX;
    }

    private static int[][] cpArr(int[][] a) {
        int[][] cp = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(a[i], 0, cp[i], 0, N);
        }
        return cp;
    }

    private static int simulation(int direction, int oldMax) {
        int max = oldMax;
        int[][] newMap = new int[N][N];
        boolean[][] isHap = new boolean[N][N];
        int[] index = new int[N];
        //위로 올리기
        if (direction == 0) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    if (index[j] == 0 || isHap[index[j] - 1][j] || newMap[index[j] - 1][j] != map[i][j]) {
                        newMap[index[j]++][j] = map[i][j];
                        continue;
                    }
                    newMap[index[j] - 1][j] *= 2;
                    isHap[index[j] - 1][j] = true;
                    max = Math.max(max, newMap[index[j] - 1][j]);
                }
            }
        } else if (direction == 1) {
            //왼쪽
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 0) continue;
                    if (index[i] == 0 || isHap[i][index[i] - 1] || newMap[i][index[i] - 1] != map[i][j]) {
                        newMap[i][index[i]++] = map[i][j];
                        continue;
                    }
                    newMap[i][index[i] - 1] *= 2;
                    isHap[i][index[i] - 1] = true;
                    max = Math.max(max, newMap[i][index[i] - 1]);
                }
            }

        } else if (direction == 2) {
            //아래
            Arrays.fill(index, N - 1);
            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if(map[i][j] == 0) continue;
                    if (index[j] == N - 1 || isHap[index[j] + 1][j] || newMap[index[j] + 1][j] != map[i][j]) {
                        newMap[index[j]--][j] = map[i][j];
                        continue;
                    }
                    newMap[index[j] + 1][j] *= 2;
                    isHap[index[j] + 1][j] = true;
                    max = Math.max(max, newMap[index[j] + 1][j]);
                }
            }
        } else {
            //오른쪽
            Arrays.fill(index, N - 1);
            for(int i=N-1;i>=0;i--){
                for (int j=N-1;j>=0;j--){
                    if(map[i][j] == 0) continue;
                    if (index[i] == N - 1 || isHap[i][index[i] + 1] || newMap[i][index[i] + 1] != map[i][j]) {
                        newMap[i][index[i]--] = map[i][j];
                        continue;
                    }
                    newMap[i][index[i] + 1] *= 2;
                    isHap[i][index[i] + 1] = true;
                    max = Math.max(max, newMap[i][index[i] + 1]);
                }
            }
        }

        map = newMap;
        return max;
    }
}
