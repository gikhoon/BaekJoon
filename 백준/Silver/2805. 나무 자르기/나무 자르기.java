import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int [] treeArray;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String bfS = bf.readLine();
        StringTokenizer st = new StringTokenizer(bfS);
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        treeArray = new int[n];

        bfS = bf.readLine();
        st = new StringTokenizer(bfS);
        for(int i=0;i<n;i++) treeArray[i] = Integer.parseInt(st.nextToken());
        long min=0,max = 0;
        for(int i : treeArray){
            max =Math.max(i,max);
        }
        long sum;
        while(true){
            sum=0;
            if(max==min){
                System.out.println(max-1);
                break;
            }
            long medium = (max+min)/2;
            for(long i:treeArray){
                if(i>medium){
                    sum+=i-medium;
                }
            }
            if(sum>=m){
                min=medium+1;
            }else{
                max=medium;
            }
        }
    }
}
