import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //금민수 값 개수
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        //입력값 처리하는 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //결과값 출력하는 BufferedWriter
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        //범위 내 금민수 개수 구하기
        search(A, B, 0L);
        System.out.println(cnt);
    }
    //백트래킹을 통해서 범위 내 금민수 값 구하는 함수
    static void search(int A, int B, long cur){
        //범위 최대값보다 클 때
        if(cur > B){
            return;
        }
        //범위 내 금민수의 값일 때
        if(cur >= A){
            cnt++;
        }
        //금민수 파생되는 값 탐색
        search(A, B, cur * 10 + 4);
        search(A, B, cur * 10 + 7);
    }
}