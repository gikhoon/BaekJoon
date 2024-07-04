import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int c = 0, r = 0;
        int min = Integer.MAX_VALUE;

        for (int i = 1; i <= R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= C; j++) {
                int value = Integer.parseInt(st.nextToken());
                if (value < min && (i + j) % 2 == 1) {
                    r = i;
                    c = j;
                    min = value;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (R % 2 != 0) {
            for (int i = 0; i < R; i++) {
                for (int j = 1; j < C; j++) {
                    if (i % 2 == 0) {
                        sb.append("R");
                    } else {
                        sb.append("L");
                    }
                }
                if (i != R - 1) {
                    sb.append("D");
                }
            }
        } else if (C % 2 != 0) {
            for (int i = 0; i < C; i++) {
                for (int j = 1; j < R; j++) {
                    if (i % 2 == 0) {
                        sb.append("D");
                    } else {
                        sb.append("U");
                    }
                }
                if (i != C - 1) {
                    sb.append("R");
                }
            }
        } else {
            if (r % 2 == 0) {
                for (int k = 0; k < r - 2; k++) {
                    for (int i = 1; i < C; i++) {
                        if (k % 2 == 0) {
                            sb.append("R");
                        } else {
                            sb.append("L");
                        }
                    }
                    sb.append("D");
                }

                for (int i = 1; i < c; i++) {
                    if (i % 2 == 0) {
                        sb.append("UR");
                    } else {
                        sb.append("DR");
                    }
                }

                for (int i = c; i < C; i++) {
                    if (i % 2 == 0) {
                        sb.append("RU");
                    } else {
                        sb.append("RD");
                    }
                }
                if (r + 1 < R) {
                    sb.append("D");
                }

                for (int i = r + 1; i <= R; i++) {
                    for (int j = C; j > 1; j--) {
                        if (i % 2 == 0) sb.append("R");
                        else sb.append("L");
                    }
                    if (i!=R) sb.append("D");
                }
            } else {
                for (int k = 0; k < r - 1; k++) {
                    for (int i = 1; i < C; i++) {
                        if (k % 2 == 0) {
                            sb.append("R");
                        } else {
                            sb.append("L");
                        }
                    }
                    sb.append("D");
                }

                for (int i = 1; i < c; i++) {
                    if (i % 2 == 0) {
                        sb.append("UR");
                    } else {
                        sb.append("DR");
                    }
                }

                for (int i = c; i < C; i++) {
                    if (i % 2 == 0) {
                        sb.append("RU");
                    } else {
                        sb.append("RD");
                    }
                }
                if (r + 2 < R) {
                    sb.append("D");
                }

                for (int i = r + 2; i <= R; i++) {
                    for (int j = C; j > 1; j--) {
                        if (i % 2 == 0) sb.append("R");
                        else sb.append("L");
                    }
                    if (i!=R) sb.append("D");
                }
            }
        }

        System.out.println(sb);
    }
}
