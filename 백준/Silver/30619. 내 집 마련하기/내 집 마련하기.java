import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter((new OutputStreamWriter(System.out)));
        int n=Integer.valueOf(br.readLine());
        int[] num=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> dict=new HashMap<>();
        for(int i=0; i<n; i++){
            num[i]=Integer.valueOf(st.nextToken());
            dict.put(num[i],i);
        }
        int m=Integer.valueOf(br.readLine());
        PriorityQueue<Integer> que=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<m; i++){
            que.clear();
            st=new StringTokenizer(br.readLine());
            int s=Integer.valueOf(st.nextToken());
            int e=Integer.valueOf(st.nextToken());
            HashMap<Integer,Integer> map=new HashMap<>(dict);
            for(int j=s; j<=e; j++){
                que.offer(j);
            }
            int[] temp=Arrays.copyOfRange(num, 0, n);
            for(int j=n-1; j>=0; j--){
                if((!que.isEmpty() && que.peek()>temp[j]) && (temp[j]>=s && temp[j]<=e)){
                    int change=temp[j];
                    temp[j]=que.poll();
                    temp[map.get(temp[j])]=change;
                    map.put(change, map.get(temp[j]));
                    map.put(temp[j],j);
                }
                else if(!que.isEmpty() && que.peek()==temp[j]){
                    que.poll();
                }
            }

            for(Integer k: temp){
                bw.write(k+" ");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}