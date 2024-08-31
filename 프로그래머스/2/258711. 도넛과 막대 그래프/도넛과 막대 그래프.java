import java.util.*;

class Solution {
    static int maxVertex = -1;
    static ArrayList<Integer>[] graph;
    static int[] incomeCount;
    static boolean[] isVisit;
    static boolean[] isVertex;
    public int[] solution(int[][] edges) {
        for(int[] edge : edges){
            maxVertex = Math.max(maxVertex, Math.max(edge[0], edge[1]));
        }
        
        graph = new ArrayList[maxVertex+1];
        incomeCount = new int[maxVertex+1];
        isVisit = new boolean[maxVertex+1];
        isVertex = new boolean[maxVertex+1];
        
        for(int i=1;i<=maxVertex;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int from = edge[0]; int to = edge[1];
            graph[from].add(to);
            incomeCount[to]++;
            isVertex[from] = true;
            isVertex[to] = true;
        }
        
        int[] answer = new int[4];
        answer[0] = getRootNode();
        answer[2] = countBarGraphs();
        answer[3] = countEightGraphs();
        answer[1] = graph[answer[0]].size()- answer[2] - answer[3];
        
        return answer;
    }
    
    public int countEightGraphs(){
        int count = 0;
        for(int i=1;i<=maxVertex;i++){
            if(!isVisit[i] && incomeCount[i] == 2 && graph[i].size() == 2){
                isVisit[i] = true;
                count++;
            }
        }
        
        return count;
    }
    
    public int countBarGraphs(){
        int count = 0;
        for(int i=1;i<=maxVertex;i++){
            if(!isVisit[i] && graph[i].size()==0 && isVertex[i]){
                isVisit[i] = true;
                count++;
            }
        }
        return count;
    }
    
    public int getRootNode(){
        int rootNode = 0;
        for(int i=1;i<=maxVertex;i++){
            if(incomeCount[i] == 0 && graph[i].size() >= 2) {
                rootNode = i;
                break;
            };
        }
        
        isVisit[rootNode] = true;
        
        for(int connectNode : graph[rootNode]){
            incomeCount[connectNode]--;
        }
        return rootNode;
    }
}