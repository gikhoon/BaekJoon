
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        /**
         * divide = 1 => 1번 0~8까지
         * divide = 3 => 3번 0~2 3~5 6~8
         * divide = 9 => 9번 0,1,2,3,
         */
        int[] answerList = new int[3];
        int divide = 1;
        while (divide <= N) {
            for (int i = 0; i < divide; i++) {
                for (int j = 0; j < divide; j++) {
                    int answer = paper[i * (N / divide)][j * (N / divide)];
                    if (answer == 2) continue;
                    boolean isSame = true;
                    for (int k = i * (N/divide); k < (i+1) * (N/divide); k++) {
                        for (int l = j * (N/divide); l < (j+1) * (N/divide); l++) {
                            if (answer != paper[k][l]) {
                                isSame = false;
                                break;
                            }
                        }
                        if (!isSame) break;
                    }

                    if (isSame){
                        answerList[answer + 1]++;
                        for (int k = i * (N/divide); k < (i+1) * (N/divide); k++) {
                            for (int l = j * (N/divide); l < (j+1) * (N/divide); l++) {
                                paper[k][l] = 2;
                            }
                        }
                    }
                }
            }
            divide *= 3;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(answerList[i]).append("\n");
        }

        System.out.println(sb);

    }
}
