import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[][] map;
    static int[] after, before;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int qRow = 0;
        after = new int[k];
        map = new String[n][k - 1];

        String[] split = br.readLine().split("");
        for (int i = 0; i < k; i++) {
            after[i] = split[i].charAt(0) - 'A';
        }

        for (int i = 0; i < n; i++) {
            split = br.readLine().split("");
            for (int j = 0; j < k - 1; j++) {
                map[i][j] = split[j];
            }
            if (map[i][0].equals("?")) {
                qRow = i;
            }
        }

        before = new int[k];
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = 0; j < qRow; j++) {
                if (index == 0) {
                    if (map[j][index].equals("-")) {
                        index++;
                    }
                } else if (index == k - 1) {
                    if (map[j][index - 1].equals("-")) {
                        index--;
                    }
                } else {
                    if (map[j][index].equals("-")) {
                        index++;
                        continue;
                    }
                    if (map[j][index - 1].equals("-")) {
                        index--;
                    }
                }
            }
            before[index] = i;
        }

        int[] before2 = new int[k];
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = n - 1; j > qRow; j--) {
                if (index == 0) {
                    if (map[j][index].equals("-")) {
                        index++;
                    }
                } else if (index == k - 1) {
                    if (map[j][index - 1].equals("-")) {
                        index--;
                    }
                } else {
                    if (map[j][index].equals("-")) {
                        index++;
                        continue;
                    }
                    if (map[j][index - 1].equals("-")) {
                        index--;
                    }
                }
            }
            before2[index] = after[i];
        }

        if (before[0] == before2[0]) {
            map[qRow][0] = "*";
        } else if (before[0] == before2[1]) {
            map[qRow][0] = "-";
        } else {
            printError(k - 1);
            return;
        }

        for (int i = 1; i < k - 1; i++) {
            if (map[qRow][i - 1].equals("-")) {
                if (before[i] != before2[i - 1]) {
                    printError(k - 1);
                    return;
                }
                map[qRow][i] = "*";
                continue;
            }
            if (before[i] == before2[i]) {
                map[qRow][i] = "*";
            } else if (before[i] == before2[i + 1]) {
                map[qRow][i] = "-";
            } else {
                printError(k - 1);
                return;
            }
        }

        if (map[qRow][k - 2].equals("-")) {
            if (before[k - 1] != before2[k - 2]) {
                printError(k - 1);
                return;
            }
        } else {
            if (before[k - 1] != before2[k - 1]) {
                printError(k - 1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k - 1; i++) {
            sb.append(map[qRow][i]);
        }
        System.out.println(sb);
    }

    private static void printError(int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            sb.append("x");
        }
        System.out.println(sb);
    }
}
