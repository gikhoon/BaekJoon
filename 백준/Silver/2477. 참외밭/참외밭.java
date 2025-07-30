import java.io.*;
import java.util.*;

class Node2 {
    int dir;
    int len;

    public Node2(int r, int c) {
        this.dir=r;
        this.len=c;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cal = Integer.parseInt(br.readLine());
    Node2[] nodes = new Node2[6];
    int[] count = new int[5];
    int sum = 1;
    StringTokenizer st;
    
    for(int i=0;i<6;i++) {
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken());
        int len = Integer.parseInt(st.nextToken());
        nodes[i] = new Node2(dir, len);
        count[dir]++;
    }
    
    for(int i=1;i<=4;i++) {
        if(count[i] == 1) {
            for(int j=0;j<6;j++) {
                if(nodes[j].dir == i) {
                    sum *= nodes[j].len;
                    break;
                }
            }
        }
    }
    
    int[] minus = new int[2];
    int index = 0;
    for(int i=0;i<6;i++) {
        int before = i-1;
        if(before == -1) {
            before = 5;
        }
        int after = (i+1) % 6;
        if(nodes[before].dir == nodes[after].dir) {
            minus[index++] = nodes[i].len;
        }
    }
    
    System.out.println((sum-minus[0] * minus[1])*cal);
}

}