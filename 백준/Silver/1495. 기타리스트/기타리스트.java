import java.util.*;
import java.io.*;
public class Main {
    static int[][] DP;
    static int[] volume;
    static int N,S,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        volume = new int[N];
        DP = new int[N][M+1];

        for(int i=0;i<N;i++)
            Arrays.fill(DP[i], Integer.MIN_VALUE);
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++)
            volume[i] = Integer.parseInt(st.nextToken());

        System.out.println(search(0, S));
    }
    //재귀를 통해서 각 볼륨의 차이를 +, -를 진행하여 모두 조절하였을 때 가장 큰 값을 구하는 함수
    static int search(int index, int value){
        //볼륨의 범위를 벗어난 경우
        if(value > M || value < 0)
            return -1;

        if(index==N)	//모든 조절이 끝날 때
            return value;

        if(DP[index][value]!=Integer.MIN_VALUE)	//이미 방문한 볼륨의 크기일 때
            return DP[index][value];
        
        DP[index][value] = Math.max(DP[index][value],
                Math.max(search(index+1, value + volume[index]), search(index+1, value-volume[index])));

        return DP[index][value];	//최대값 반환
    }
}