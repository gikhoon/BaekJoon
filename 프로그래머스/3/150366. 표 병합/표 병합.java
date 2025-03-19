import java.util.*;

class Node {
    int r;
    int c;
    
    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(r,c);
    }
    
    @Override
    public boolean equals(Object o) {
        Node o2 = (Node) o;
        return r == o2.r && c == o2.c;
    }
}

class Solution {
    private Node[][] parent = new Node[51][51];
    private String[][] data = new String[51][51];
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        for(int i=1;i<=50;i++) {
            for(int j=1;j<=50;j++) {
                parent[i][j] = new Node(i,j);
            }
        }
        
        for(String command : commands) {
            String[] split = command.split(" ");
            String mainC = split[0];
            if(mainC.equals("UPDATE")) {
                if(split.length == 4) {
                    int r = Integer.parseInt(split[1]);
                    int c = Integer.parseInt(split[2]);
                    Node p = findParent(r,c);
                    data[p.r][p.c] = split[3];
                } else {
                    updateAll(split[1], split[2]);
                }
            } else if(mainC.equals("MERGE")) {
                merge(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
            } else if(mainC.equals("UNMERGE")) {
                unmerge(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
            } else {
                Node p = findParent(Integer.parseInt(split[1]), Integer.parseInt(split[2]));
                String d = data[p.r][p.c];
                if(d == null) {
                    d = "EMPTY";
                }
                answer.add(d);
            }
        }
        
        return answer.toArray(String[]::new);
    }
    
    private void merge(int r1, int c1, int r2, int c2) {
    Node p1 = findParent(r1, c1);
    Node p2 = findParent(r2, c2);
    if (p1.equals(p2)) return;
    
    // p2 그룹에 속하는 모든 셀의 대표를 p1으로 업데이트
    for (int i = 1; i <= 50; i++) {
        for (int j = 1; j <= 50; j++) {
            if (findParent(i, j).equals(p2)) {
                parent[i][j] = p1;
            }
        }
    }
    
    // 두 셀 모두 값이 있는 경우, (r1, c1)의 값을 유지하도록 함
    if (data[p1.r][p1.c] == null) {
        data[p1.r][p1.c] = data[p2.r][p2.c];
    }
}



    
    private void unmerge(int r, int c) {
        Node p = findParent(r,c);
        String d = data[p.r][p.c];
        for(int i=1;i<=50;i++) {
            for(int j=1;j<=50;j++) {
                Node cur = findParent(i,j);
                if(cur.r == p.r && cur.c == p.c) {
                    data[i][j] = null;
                    parent[i][j] = new Node(i,j);
                }
            }
        }
        
        data[r][c] = d;
        
        Node cur = parent[r][c];
    }
    
    private void updateAll(String value, String value2) {
        for(int i=1;i<=50;i++) {
            for(int j=1;j<=50;j++) {
                if(data[i][j] != null && data[i][j].equals(value)) {
                    data[i][j] = value2;
                }
            }
        }
    }
    
    private Node findParent(int r, int c) {
        Node p = parent[r][c];
        if(p.r == r && p.c == c) {
            return p; 
        }
        return parent[r][c] = findParent(p.r,p.c);
    }
}