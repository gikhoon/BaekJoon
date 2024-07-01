
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] video;
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                if (split[j].equals("1")) video[i][j] = true;
            }
        }

        compressVideo(N, 0, 0);

        System.out.println(sb);
    }

    private static void compressVideo(int size, int x, int y) {
        if (isSame(x, y, size)) {
            sb.append(video[x][y] ? "1" : "0");
            return;
        }

        int newSize = size / 2;
        sb.append("(");
        compressVideo(newSize, x, y);
        compressVideo(newSize, x, y + newSize);
        compressVideo(newSize, x + newSize, y);
        compressVideo(newSize, x + newSize, y + newSize);
        sb.append(")");
    }

    private static boolean isSame(int x, int y, int size) {
        boolean first = video[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (video[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}
