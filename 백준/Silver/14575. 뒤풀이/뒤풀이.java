import java.io.*;
import java.util.*;

public class Main {
    static int T, N;
    static int[][] drink;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N  = Integer.parseInt(st.nextToken()); // 참가자 수 
        T  = Integer.parseInt(st.nextToken()); // 술 총합

        drink = new int[N][2];
        int high_sum=0, low_sum=0;
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            drink[i][0] = Integer.parseInt(st.nextToken());
            drink[i][1] = Integer.parseInt(st.nextToken());

            low_sum += drink[i][0];
            high_sum += drink[i][1];
        }

        if(low_sum > T || high_sum < T) {
            System.out.println(-1);
            System.exit(0);
        }

        System.out.println(Search_S(T, 0));
    }

    static int Search_S(int high, int low) {
        int mid = (high+low)/2;
        if(low > high) {
            return low;
        }

        int sum=0;
        for (int i=0; i<N; i++) {
            if (drink[i][0] > mid) {
                return Search_S(high, mid+1);
            }
            sum += Math.min(drink[i][1],mid);
        }

        if (sum >= T) {
            return Search_S(mid-1, low);
        }else{
            return Search_S(high, mid+1);
        }
    }
}
