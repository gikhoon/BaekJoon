import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] ability;
    static int MIN = Integer.MAX_VALUE;
    static boolean[] isTeam;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        ability = new int[N][N];
        isTeam = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                ability[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selectTeam(0, 0);

        System.out.println(MIN);
    }

    private static void selectTeam(int start, int count) {
        if (count == N / 2) {
            checkAbility();
            return;
        }

        for (int i = start; i <= N/2 + count; i++) {
            isTeam[i] = true;
            selectTeam(i + 1, count + 1);
            isTeam[i] = false;
        }
    }

    private static void checkAbility() {
        int teamA = 0;
        int teamB = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isTeam[i] == isTeam[j]) {
                    if (isTeam[i]) {
                        teamA = teamA + ability[i][j] + ability[j][i];
                    } else {
                        teamB = teamB + ability[i][j] + ability[j][i];
                    }
                }
            }
        }

        MIN = Math.min(MIN, Math.abs(teamA - teamB));
    }
}