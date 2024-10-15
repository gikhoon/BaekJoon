import java.util.*;
import java.lang.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delIdx = -1;
        int pickIdx = -1;
        for(int i=n-1;i>=0;i--){
            if(delIdx == -1 && deliveries[i] !=0) delIdx = i;
            if(pickIdx == -1 && pickups[i] !=0) pickIdx = i;
            
            if(delIdx !=-1 && pickIdx !=-1) break;
        }
        //2
        //[1, 0, 3, 0, 0] 3
        //[0, 3, 0, 4, 0] 3
        
        while(delIdx>=0 || pickIdx>=0){
            int currentCap = cap;
            answer += Math.max(delIdx,pickIdx) + 1;
            while(delIdx >= 0){
                if(deliveries[delIdx] > currentCap){
                    deliveries[delIdx] -= currentCap;
                    break;
                } else {
                    currentCap -= deliveries[delIdx];
                    deliveries[delIdx] = 0;
                    delIdx--;
                }
            }
            
            currentCap = cap;
            while(pickIdx >= 0){
                if(pickups[pickIdx] > currentCap){
                    pickups[pickIdx] -= currentCap;
                    break;
                } else {
                    currentCap -= pickups[pickIdx];
                    pickups[pickIdx] = 0;
                    pickIdx--;
                }
            }
        }
        return answer * 2;
    }
}