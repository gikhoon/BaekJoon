class Solution {
    int[] diffs; int[] times;
    public int solution(int[] diffs, int[] times, long limit) {
        this.diffs = diffs;
        this.times = times;
        int min = 1; int max = 100000;
        while(min <= max) {
            int mid = (min+max) /2;
            long time = cal(mid);
            //너무 많이 걸리면 더해
            if(time > limit) min = mid + 1;
            else{
                max = mid - 1;
            }
        }
        return max+1;
    }
    
    private long cal(int level) {
        long answer = 0;
        for(int i=0;i<diffs.length;i++) {
            if(diffs[i] <= level) {
                answer += times[i];
            } else {
                answer += (long)(times[i] + times[i-1]) * (long)(diffs[i] - level) + times[i];
            }
        }
        return answer;
    }
    
    //1~어디 사이인지 찾기
    //작은 것은 빼고 나머지는 일차 방정식을 세운다
    //계산
    
    //1 54 209 328 467
    //1 ->안됨
    //54일때 -> 
}