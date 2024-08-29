import java.io.IOException;
import java.io.*;
import java.util.*;

public class Main {
    static int[] dice = new int[6];
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int[][] map;
    static int N, M;
    static int r, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int commandSize = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < commandSize; i++) {
            int command = Integer.parseInt(st.nextToken());
            if (canMove(command)) {
                moveDice(command);
                r += dr[command - 1];
                c += dc[command - 1];
                sb.append(dice[0]).append("\n");
                if (map[r][c] == 0) {
                    map[r][c] = dice[5];
                } else {
                    dice[5] = map[r][c];
                    map[r][c] = 0;
                }
            }
        }

        System.out.println(sb);
    }

    private static boolean canMove(int command) {
        int newR = r + dr[command - 1];
        int newC = c + dc[command - 1];
        return (newR >= 0 && newR <= N - 1) && (newC >= 0 && newC <= M - 1);
    }

    private static void moveDice(int command) {
        int[] newDice = dice.clone();
        switch(command) {
            case 1:
                newDice[3] = dice[5];
                newDice[0] = dice[3];
                newDice[2] = dice[0];
                newDice[5] = dice[2];
                break;
            case 2:
                newDice[0] = dice[2];
                newDice[3] = dice[0];
                newDice[2] = dice[5];
                newDice[5] = dice[3];
                break;
            case 3:
                newDice[0] = dice[4];
                newDice[1] = dice[0];
                newDice[4] = dice[5];
                newDice[5] = dice[1];
                break;
            default:
                newDice[0] = dice[1];
                newDice[1] = dice[5];
                newDice[4] = dice[0];
                newDice[5] = dice[4];
                break;
        }
        dice = newDice;
    }
}
