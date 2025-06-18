import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Ball[] balls = new Ball[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            balls[i] = new Ball(i, c, s);
        }

        Arrays.sort(balls, Comparator.comparingInt(b -> b.size));

        int[] result = new int[N];
        int[] colors = new int[N + 1];
        int ball_idx = 0;
        int sum = 0;

        for (int i = 0; i < N; i++) {
            Ball cur = balls[i];
            while (balls[ball_idx].size < cur.size) {
                sum += balls[ball_idx].size;
                colors[balls[ball_idx].color] += balls[ball_idx].size;
                ball_idx++;
            }
            result[cur.idx] = sum - colors[cur.color];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}

class Ball {
    int idx, color, size;

    public Ball(int idx, int color, int size) {
        this.idx = idx;
        this.color = color;
        this.size = size;
    }
}