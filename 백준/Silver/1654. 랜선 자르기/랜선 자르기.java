import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] list = new int[k];

        long high = 0;
        long low = 1;
        long sum;
        long middle=0;
        for(int i=0;i<k;i++){
            list[i] = Integer.parseInt(br.readLine());
            if(high<list[i]) high=list[i];
        }
        while(true){
            if(low>high){
                System.out.println(high);
                break;
            }
            sum = 0;
            middle = (low+high)/2;
            for(int i=0;i<k;i++){
                sum+=list[i]/middle;
            }
            if(sum<n) high=middle-1;
            else low=middle+1;
        }
    }
}
