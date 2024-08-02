import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int appleCount = Integer.parseInt(br.readLine());

        for (int i = 0; i < appleCount; i++) {
            st = new StringTokenizer(br.readLine());
            board[N - Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken()) - 1] = 2;
        }

        int commandCount = Integer.parseInt(br.readLine());
        int timeCount = 0;
        Queue<Integer> snakeR = new LinkedList<>();
        Queue<Integer> snakeC = new LinkedList<>();
        snakeR.add(N-1);
        snakeC.add(0);
        int headR = N-1; int headC = 0;
        int movingIndex = 0;
        int[] movingR = {0, 1, 0, -1};
        int[] movingC = {1, 0, -1, 0};
        board[headR][headC] = 1;
        for (int i = 0; i < commandCount; i++) {
            st = new StringTokenizer(br.readLine());
            int commandTime = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            for (int t = timeCount; t < commandTime; t++) {
                timeCount++;
                headR += movingR[movingIndex];
                headC += movingC[movingIndex];
                if (!isValid(headR, headC, N)) {
                    System.out.println(timeCount);
                    return;
                }
                if (board[headR][headC] != 2) {
                    Integer r = snakeR.poll();
                    Integer c = snakeC.poll();
                    board[r][c] = 0;
                }
                snakeR.add(headR);
                snakeC.add(headC);
                board[headR][headC] = 1;
            }

            if ("D".equals(command)) {
                if (movingIndex == 0) movingIndex = 3;
                else movingIndex--;
            } else {
                movingIndex = (movingIndex + 1) % 4;
            }
        }

        while (true) {
            timeCount++;
            headR += movingR[movingIndex];
            headC += movingC[movingIndex];
            if (!isValid(headR, headC, N)) {
                System.out.println(timeCount);
                return;
            }
            if (board[headR][headC] != 2) {
                Integer r = snakeR.poll();
                Integer c = snakeC.poll();
                board[r][c] = 0;
            }
            snakeR.add(headR);
            snakeC.add(headC);
            board[headR][headC] = 1;
        }
    }

    private static boolean isValid(int headR, int headC, int n) {
        return (headR >= 0 && headR < n && headC >= 0 && headC < n) && board[headR][headC] != 1;
    }
}

