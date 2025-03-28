import java.util.*;

class Node {
    int num;
    int count;
    
    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

class Solution {
    public int solution(int x, int y, int n) {
        Set<Integer> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        if(x == y) return 0;
        set.add(x);
        q.add(new Node(x,0));
        while(!q.isEmpty()) {
            Node cur = q.poll();
            int num = cur.num;
            if(!set.contains(num + n) && num + n <= y) {
                if(num+n == y) return cur.count+1;
                q.add(new Node(num+n, cur.count+1));
                set.add(num+n);
            }
            if(!set.contains(num * 2) && num * 2 <=y) {
                if(num * 2 == y) return cur.count+1;
                q.add(new Node(num * 2, cur.count+1));
                set.add(num * 2);
            }
            if(!set.contains(num * 3) && num * 3 <=y) {
                if(num * 3 == y) return cur.count+1;
                q.add(new Node(num * 3, cur.count+1));
                set.add(num * 3);
            }
                      
        }
        return -1;
    }
}