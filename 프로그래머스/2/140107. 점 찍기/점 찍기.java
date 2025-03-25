class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        for(int a=0;a<=d;a+=k) {
            long length = (long) Math.sqrt(Math.pow(d,2) - Math.pow(a,2));
            answer += length / k + 1;
        }
        return answer;
    }
}