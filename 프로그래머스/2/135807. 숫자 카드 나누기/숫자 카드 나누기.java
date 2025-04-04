import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = getGcd(arrayA);
        int b = getGcd(arrayB);
        
        boolean flagA = a != 1 && canNotAllElementDivide(a, arrayB);
        boolean flagB = b != 1 && canNotAllElementDivide(b, arrayA);
        
        int answer = 0;
        if(flagA && flagB)answer = Math.max(a,b);
        else if(flagA) answer = a;
        else if(flagB)answer = b;
        
        return answer;
    }
    int getGcd(int[] arr){
        int res = arr[0];
        for(int i = 1; i < arr.length ; i++){
            res = gcd(res, arr[i]);
            if(res == 1) break;
        }
        return res;
    }
    int gcd(int a,int b){
        if(a == 0) return b;
        return gcd(b % a, a);
    }
 
    boolean canNotAllElementDivide(int num, int[] arr){ 
        // 모든 원소가 num으로 나누어 떨어지지 않는다
        return Arrays.stream(arr).allMatch(i -> i% num != 0);
    }
}