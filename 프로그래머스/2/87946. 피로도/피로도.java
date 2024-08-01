class Solution {
    static int[] order;
    static int answer;
    public int solution(int k, int[][] dungeons) {
        answer = -1;
        order = new int[dungeons.length];
        for(int i=0;i<order.length;i++){
            order[i] = i;
        }
        
        permutation(dungeons,0,order.length,k);
        return answer;
    }
    
    void permutation(int[][] dungeons, int start, int end,int health){
        if(start==end){
            answer = Math.max(answer,test(health, dungeons));
            return;
        }
        
        for(int i=start;i<end;i++){
            swap(start, i);
            permutation(dungeons, start+1,end, health);
            swap(start, i);
        }
    }
    
    void swap(int start, int end){
        int tmp = order[start];
        order[start] = order[end];
        order[end] = tmp;
    }
    
    int test(int health, int[][] dungeons) {
        int index = 0;
        while(index < order.length && dungeons[order[index]][0] <= health){
            health -= dungeons[order[index++]][1];
        }
        
        return index;
    }
}