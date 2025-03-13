import java.util.*;

class Node {
    int num;
    int len;
    
    public Node(int num, int len) {
        this.num = num;
        this.len = len;
    }
}

class Solution {
    private int answer = 0;
    private int maxLen = 0;
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] edgeList = new ArrayList[n+1];
        boolean[] isVisit = new boolean[n+1];
        for(int i=1;i<=n;i++) {
            edgeList[i] = new ArrayList<>();
        }
        for(int[] data : edge) {
            edgeList[data[0]].add(data[1]);
            edgeList[data[1]].add(data[0]);
        }
        
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1,0));
        isVisit[1] = true;
        while(!q.isEmpty()) {
            Node cur = q.poll();
            if(cur.len != maxLen) {
                maxLen = cur.len;
                answer = q.size() + 1;
            }
            
            for(int next : edgeList[cur.num]) {
                if(!isVisit[next]) {
                    isVisit[next] = true;
                    q.add(new Node(next, cur.len +1));
                }
            }
        }
        return answer;
    }
}