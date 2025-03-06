class Solution {
    public int[] solution(int brown, int yellow) {
        int r = 0; int c = 0;
        for(int i=1;i*i<=yellow;i++) {
            if(yellow % i != 0) continue;
            int j = yellow / i;
            if((j + 2) * (i + 2) - yellow == brown) {
                r = j + 2;
                c = i + 2;
                break;
            }
        }
        int[] answer = {r, c};
        return answer;
    }
}