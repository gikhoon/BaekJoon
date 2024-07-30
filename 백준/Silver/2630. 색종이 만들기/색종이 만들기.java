import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int blue = 0;
    static int white = 0;

    static boolean[][] paper;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        paper = new boolean[N][N];

        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<N;j++){
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) paper[i][j] = true;
            }
        }

        findAnswer(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    private static void findAnswer(int r, int c, int size) {
        boolean first = paper[r][c];
        boolean isSame = true;

        for (int i=r;i<r+size;i++){
            for (int j=c;j<c+size;j++){
                if (paper[i][j] != first){
                    isSame = false;
                    break;
                }
            }
            if (!isSame) break;
        }

        if (isSame) {
            if (first) blue++;
            else white++;
        } else {
            findAnswer(r,c,size/2);
            findAnswer(r + size/2,c,size/2);
            findAnswer(r,c + size/2,size/2);
            findAnswer(r + size/2,c + size/2,size/2);
        }
    }
}
