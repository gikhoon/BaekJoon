class Solution {
    static int[] count;
    static int[] max;
    public int[] solution(int e, int[] starts) {
        count = new int[e+1];
        max = new int[e+1];
        
        for(int i=1;i<=e;i++) {
            for(int j=1;j<=e/i;j++) {
                count[i*j]++;
            }
        }
        
        max[e] = e; //가장 큰 값의 인덱스
        for(int i=e-1;i>=1;i--) {
            int ne = count[i]; //새 것의 약수 갯수
            if(ne >= count[max[i+1]]) {
                max[i] = i;
            } else {
                max[i] = max[i+1];
            }
        }
        
        int[] answer = new int[starts.length];
        for(int i=0;i<starts.length;i++) {
            answer[i] = max[starts[i]];
        }
        return answer;
    }
}