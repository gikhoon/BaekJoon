class Solution {
    double[] discount = {0.9, 0.8, 0.7, 0.6};
    int[] percent = {10,20,30,40};
    int[] discountIndex;
    int maxPlus = 0;
    int maxCost = 0;
    private int[] emoticons;
    private int[][] users;
    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        discountIndex = new int[emoticons.length];
        dfs(0);
        int[] answer = {maxPlus, maxCost};
        return answer;
    }
    
    private void dfs(int index) {
        if(index == discountIndex.length) {
            calculate(discountIndex);
            return;
        }
        
        for(int d=0;d<4;d++) {
            discountIndex[index] = d;
            dfs(index+1);
        }
    }
    
    private void calculate(int[] discountIndex) {
        
        int plusCount = 0;
        int sum = 0;
        for(int[] user : users) {
            int userCost = 0;
            int discountMax = user[0];
            for(int i=0;i<discountIndex.length;i++) {
                if(percent[discountIndex[i]] >= discountMax) {
                    userCost += emoticons[i] * discount[discountIndex[i]];
                }
            }
            
            if(userCost >= user[1]) {
                plusCount++;
            } else {
                sum += userCost;
            }
        }
        
        if(plusCount > maxPlus) {
            maxPlus = plusCount;
            maxCost = sum;
        } else if(plusCount == maxPlus && maxCost < sum) {
            maxCost = sum;
        }
    }
    
    //700 * 2^14
}