import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int answer = Integer.MIN_VALUE;
    static int[][] arr;
    static boolean[][] isVisited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findAnswer(0, 0, 0, 0, K);
        System.out.println(answer);
    }

    private static void findAnswer(int r, int c, int count, int sum, int max) {
        if (count == max) {
            answer = Math.max(answer, sum);
            return;
        }

        for (int i = c; i < arr[0].length; i++) {
            if (isValid(r, i)) {
                sum += arr[r][i];
                isVisited[r][i] = true;
                findAnswer(r, i, count + 1, sum, max);
                sum -= arr[r][i];
                isVisited[r][i] = false;
            }
        }

        for (int i = r + 1; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (isValid(i, j)) {
                    sum += arr[i][j];
                    isVisited[i][j] = true;
                    findAnswer(i, j, count + 1, sum, max);
                    sum -= arr[i][j];
                    isVisited[i][j] = false;
                }
            }
        }
    }

    private static boolean isValid(int r, int c) {
        if(isVisited[r][c]) return false;
        for (int d = 0; d < 4; d++) {
            int newR = r + dr[d];
            int newC = c + dc[d];
            if (newR < 0 || newR >= arr.length || newC < 0 || newC >= arr[0].length) {
                continue;
            }

            if (isVisited[newR][newC]) {
                return false;
            }
        }

        return true;
    }
}