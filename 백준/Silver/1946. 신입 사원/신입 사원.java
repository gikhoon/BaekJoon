import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Rank {
    int a;
    int b;

    public Rank(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            Rank[] ranks = new Rank[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                ranks[j] = new Rank(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(ranks, Comparator.comparingInt(r -> r.a));
            int min = n + 1;
            int answer = 0;
            for (Rank r : ranks) {
                if (r.b < min) {
                    min = r.b;
                    answer++;
                }
            }
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}