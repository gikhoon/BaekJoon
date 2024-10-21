import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[][] lastMonth = new int[friends.length+1][friends.length+1];
        Map<String, Integer> index = new HashMap<>();
        
        for(int i=0;i<friends.length;i++){
            index.put(friends[i], i);
        }
        
        for(String gift : gifts){
            String[] split = gift.split(" ");
            String from = split[0];
            String to = split[1];
            
            lastMonth[index.get(from)][index.get(to)]++;
            lastMonth[friends.length][index.get(to)]++;
            lastMonth[index.get(from)][friends.length]++;
        }
        
        for(int i=0;i<friends.length;i++){
            int getGift = 0;
            for(int j=0;j<friends.length;j++){
                if(lastMonth[i][j] + lastMonth[j][i] != 0 && lastMonth[i][j] > lastMonth[j][i]) getGift++;
                else if(lastMonth[i][j] == lastMonth[j][i]){
                    int iDegree =  lastMonth[i][friends.length] - lastMonth[friends.length][i];
                    int jDegree =  lastMonth[j][friends.length] - lastMonth[friends.length][j];
                    
                    if(iDegree > jDegree) getGift++; 
                }
            }
            
            System.out.println(friends[i] + lastMonth[i][friends.length] + lastMonth[friends.length][i]);
            answer = Math.max(getGift, answer);
        }
        
        return answer;
    }
}