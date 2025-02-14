import java.util.*;
import java.io.*;

class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[M];
        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++){
                if(i==0) arr[j] = String.valueOf(s.charAt(j));
                else arr[j] += String.valueOf(s.charAt(j));
            }
        }

        if(N == 2){
            System.out.println(0);
            return;
        }

        for(int i=1;i<N-1;i++){
            Set<String> set = new HashSet<>();

            for(int j=0;j<M;j++){
                String key = arr[j].substring(i);
                if(set.contains(key)){
                    System.out.println(i-1);
                    return;
                }
                else set.add(key);
            }

        }
        System.out.println(N-1);
    }
}