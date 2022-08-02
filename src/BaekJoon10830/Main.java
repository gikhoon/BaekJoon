package BaekJoon10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int [][] A1;
    static int [][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        A1 = new int[N][N];
        result = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A1[i][j] = Integer.parseInt(st.nextToken())%1000;
            }
        }

        result = pow(A1, B);

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    static int[][] pow(int[][] list,long exp){
        if(exp==1L){
            return list;
        }
        int[][] result = pow(list,exp/2);
        result = multiple(result, result);

        if(exp%2==1L){
            result=multiple(result,A1);
        }

        return result;

    }
    static int[][] multiple(int[][] A,int[][] B){
        int N = A1.length;
        int[][] result = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int sum=0;
                for(int k=0;k<N;k++){
                    sum+=A[i][k]*B[k][j];
                }
                result[i][j]=sum%1000;
            }
        }
        return result;
    }
}
