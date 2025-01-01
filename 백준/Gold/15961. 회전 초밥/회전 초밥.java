import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 가짓수
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); // 쿠폰 번호

        int[] dish = new int[N];
        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine());
        }

        int[] eatSushi = new int[d + 1]; // 초밥 종류별 먹은 횟수
        int total = 0; // 현재 먹은 초밥의 가짓수
        int max = 0; // 최댓값 저장
        
        for (int i = 0; i < k; i++) {
            if (eatSushi[dish[i]] == 0) {
                total++;
            }
            eatSushi[dish[i]]++;
        }
        
        max = (eatSushi[c] == 0) ? total + 1 : total;
        
        for (int start = 0; start < N; start++) {
            int end = (start + k) % N; // 회전 고려하여 끝 점 계산
            
            if (eatSushi[dish[start]] == 1) {
                total--;
            }
            eatSushi[dish[start]]--;
            
            if (eatSushi[dish[end]] == 0) {
                total++;
            }
            eatSushi[dish[end]]++;
            
            int currentMax = (eatSushi[c] == 0) ? total + 1 : total;
            max = Math.max(max, currentMax);
        }

        System.out.println(max);
    }
}
