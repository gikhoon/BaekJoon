import java.util.*;

class Solution {
    private int answer = 0;
    private int[][] q;
    private int[] ans;
    private int n;
    public int solution(int n, int[][] q, int[] ans) {
        this.q = q;
        this.ans = ans;
        this.n = n;
        dfs(0, 1, new int[5]);
        return answer;
    }
    
    private void dfs(int index, int start, int[] pick) {
        if(index == 5) {
            check(pick);
            return;
        }
        if(start > n) return;
        for(int i=start;i<=n;i++) {
            pick[index] = i;
            dfs(index+1, i+1, pick);
        }
    }
    
    private void check(int[] pick) {
        Set<Integer> set = new HashSet<>();
        for(int num : pick) {
            set.add(num);
        }
        for(int i=0;i<ans.length;i++) {
            int count = 0;
            for(int num : q[i]) {
                if(set.contains(num)) {
                    count++;
                }
            }
            
            if(count != ans[i]) return;
        }
        answer++;
    }
}