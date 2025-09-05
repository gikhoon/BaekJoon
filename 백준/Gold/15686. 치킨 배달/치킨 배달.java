import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static List<Node> house = new ArrayList<>();
    static List<Node> chicken = new ArrayList<>();
    static boolean[] isVisited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                int data = Integer.parseInt(st.nextToken());
                if(data==1){
                    house.add(new Node(i, j));
                }else if(data==2){
                    chicken.add(new Node(i, j));
                }
            }
        }
        isVisited = new boolean[chicken.size()];

        backTracking(0,0);
        System.out.println(min);

    }
    private static void backTracking(int deep, int index){
        if(deep==M){
            int cityLength = 0;
            for (Node node : house) {
                int sum = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (isVisited[j]) {
                        int dist = Math.abs(node.r - chicken.get(j).r)
                                + Math.abs(node.c - chicken.get(j).c);
                        sum = Math.min(sum, dist);
                    }
                }
                cityLength += sum;
            }
            min = Math.min(cityLength, min);
            return;
        }
        for(int i=index;i<chicken.size();i++){
            if(!isVisited[i]){
                isVisited[i]=true;
                backTracking(deep+1,i+1);
                isVisited[i]=false;
            }
        }
    }
}
class Node{
    int r;
    int c;
    Node(int r,int c){
        this.r=r;
        this.c=c;
    }
}
