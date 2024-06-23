import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Node{
    private int n;
    private int m;
    private boolean isOpen;
    private boolean isVisited;
    private int length;
    Node(int n,int m,int i){
        this.n=n;
        this.m=m;
        isOpen=true;
    }
    Node(int n,int m){
        this.n=n;
        this.m=m;
    }
    int getLength(){return length;}
    boolean getIsVisited(){return isVisited;}
    boolean getIsOpen(){return isOpen;}
    void setVisited(){isVisited=true;}
    void setLength(int i){length=i;}
    int getN(){
        return n;
    }
    int getM(){
        return m;
    }
}

public class Main {
    static int[] dUD = {0, 0, 1, -1};
    static int [] dRL = {1,-1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node [][] maze = new Node[n+2][m+2];
        for(int i=0;i<m+2;i++){
            maze[0][i]=new Node(0,i);
            maze[n + 1][i] = new Node(n + 1, i);
        }
        for(int i=1;i<n+1;i++){
            maze[i][0] = new Node(i, 0);
            maze[i][m + 1] = new Node(i, m + 1);
        }
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                if(str.charAt(j)=='1') maze[i][j+1]=new Node(i,j+1,1);
                else maze[i][j+1]= new Node(i,j+1);
            }
        }
        Queue<Node> q = new LinkedList<>();
        int currentN=1; int currentM=1;
        q.add(maze[1][1]);
        maze[1][1].setVisited();
        maze[1][1].setLength(1);
        while(true){
            Node currentNode = q.poll();
            currentN=currentNode.getN(); currentM=currentNode.getM();
            for(int i=0;i<4;i++){
                int newN = currentN+dUD[i]; int newM = currentM+dRL[i];
                if((!maze[newN][newM].getIsVisited())&& (maze[currentN+dUD[i]][currentM+dRL[i]].getIsOpen())){
                    q.add(maze[newN][newM]);
                    maze[newN][newM].setVisited();
                    maze[newN][newM].setLength(currentNode.getLength()+1);
                    if(newN==n&&newM==m){
                        System.out.println(maze[newN][newM].getLength());
                        return;
                    }
                }
            }
        }

    }
}
