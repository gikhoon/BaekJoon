import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] map;
    static int N;
    static int one = 0, zero = 0;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new boolean[N][N];
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (st.nextToken().equals("1")) {
                    map[i][j] = true;
                }
            }
        }

        find(0, 0, N);
        System.out.println(zero);
        System.out.println(one);
	}

    private static void find(int startR, int startC, int size) {
        boolean de = map[startR][startC];
        boolean isSame = true;
        for (int i = startR; i < startR + size; i++) {
            if(!isSame) break;
            for (int j = startC; j < startC + size; j++) {
                if (map[i][j] != de) {
                    isSame = false;
                    break;
                }
            }
        }

        if (isSame) {
            if(de) {
                one++;
            } else {
                zero++;
            }
        } else {
            int newSize = size /2;
            find(startR, startC, newSize);
            find(startR, startC + newSize, newSize);
            find(startR + newSize, startC, newSize);
            find(startR + newSize, startC + newSize, newSize);
        }

    }
}
