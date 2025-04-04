import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        int count = 0;
        
        while(left <= right) {
            if(limit >= people[left] + people[right]) {
                left++;
            }
            right--;
            count++;
        }
        
        return count;
    }
}