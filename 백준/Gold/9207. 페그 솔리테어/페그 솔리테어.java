import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int minPin;
    static int minMove;
    static char[][] map;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            minPin = Integer.MAX_VALUE;
            minMove = Integer.MAX_VALUE;
            Queue<String> q = new LinkedList<>();
            String s = br.readLine();
            while (s!=null && !s.isEmpty() ) {
                q.add(s);
                s = br.readLine();
            }

            int totalPin = 0;
            if (q.isEmpty()) {
                sb.append(0).append(" ").append(0).append("\n");
                continue;
            }
            map = new char[q.size()][q.peek().length()];

            int i=0;
            while (!q.isEmpty()) {
                s = q.poll();
                for (int j = 0; j < s.length(); j++) {
                    char c = s.charAt(j);
                    map[i][j] = c;
                    if (c=='o') totalPin++;
                }
                i++;
            }

            dfs(0, totalPin);
            sb.append(minPin).append(" ").append(minMove).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int moveCount, int pinLeft) {
        if (pinLeft < minPin || (pinLeft == minPin && moveCount < minMove)) {
            minPin = pinLeft;
            minMove = moveCount;
        }

        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[0].length;j++) {
                if (map[i][j] == 'o') {
                    for (int d = 0; d < 4; d++) {
                        if (canPop(i, j, i + dr[d], j + dc[d])) {
                            int newR1 = i + dr[d] * 2;
                            int newC1 = j + dc[d] * 2;
                            map[newR1][newC1] = 'o';
                            map[i][j] = '.';
                            map[i+dr[d]][j+dc[d]] = '.';
                            dfs(moveCount+1, pinLeft-1);
                            map[newR1][newC1] = '.';
                            map[i][j] = 'o';
                            map[i+dr[d]][j+dc[d]] = 'o';
                        }
                    }
                }
            }
        }
    }

    private static boolean canPop(int r1, int c1, int r2, int c2) {
        if (r2 < 0 || r2 >= map.length || c2 < 0 || c2 >= map[0].length) return false;
        if (map[r2][c2] != 'o') return false;
        int newR1 = r1 + (r2 - r1) * 2;
        int newC1 = c1 + (c2 - c1) * 2;
        if (newR1 < 0 || newR1 >= map.length || newC1 < 0 || newC1 >= map[0].length) return false;

        return map[newR1][newC1] == '.';
    }
}
