import java.io.*;
import java.util.*;

class Chim {
    int r, c; // r=세로, c=가로
    Chim(int r, int c){ this.r=r; this.c=c; }
}

public class Main {
    static int N, M, K; // M=가로(열), N=세로(행)
    static Chim[] chims;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        int T = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chims = new Chim[T];
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken()); // 가로
            int r = Integer.parseInt(st.nextToken()); // 세로
            chims[i] = new Chim(r, c);
        }

        // 아래변(bottom) 후보: 각 보석 r을 N-K 경계로 클램프
        HashSet<Integer> bottoms = new HashSet<>();
        for (Chim p : chims) {
            int b = p.r;
            if (b + K > N) b = N - K;
            if (b < 0) b = 0;
            bottoms.add(b);
        }

        int bestCnt = 0;
        int bestX = 0, bestYTop = 0;

        // 각 bottom마다: 세로 [bottom, bottom+K]에 들어오는 점들만 가로 스윕(차분배열)
        // 차분배열을 M+1로 만들어 R+1 감소도 안전하게 처리
        int[] diff = new int[M + 1]; // 재사용해 GC 줄임
        for (int bottom : bottoms) {
            Arrays.fill(diff, 0);

            for (Chim p : chims) {
                if (bottom <= p.r && p.r <= bottom + K) {
                    int L = Math.max(0, p.c - K);   // 왼변이 올 수 있는 최소 x
                    int R = Math.min(p.c, M - 1);   // 포함 구간 오른끝(포함)

                    diff[L] += 1;
                    diff[R + 1] -= 1;               // R+1에서 감소 (배열이 M+1이라 안전)
                }
            }

            int cur = 0;
            for (int x = 0; x < M; x++) {
                cur += diff[x];
                if (cur > bestCnt) {
                    bestCnt = cur;
                    bestX = x;               // 왼쪽 위 꼭짓점 X
                    bestYTop = bottom + K;   // 위변 Y (문제 출력 형식)
                }
            }
        }

        System.out.println(bestX + " " + bestYTop);
        System.out.println(bestCnt);
    }
}
