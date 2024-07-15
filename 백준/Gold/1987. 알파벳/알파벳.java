import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int answer = 0;

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static String[][] list;

    static int R,C;

    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        list = new String[R][C];
        for (int i = 0; i < R; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < C; j++) {
                list[i][j] = split[j];
            }
        }
        set.add(list[0][0]);
        countAnswer(0, 0, 1);

        System.out.println(answer);
    }

    private static void countAnswer(int r, int c, int count) {
        for (int i = 0; i < 4; i++) {
            int newR = r + dr[i];
            int newC = c + dc[i];
            if (newR >= 0 && newR < R && newC >= 0 && newC < C) {
                if (!set.contains(list[newR][newC])) {
                    set.add(list[newR][newC]);
                    countAnswer(newR, newC, count+1);
                    set.remove(list[newR][newC]);
                }
            }
        }

        answer = Math.max(answer, count);


    }
}

