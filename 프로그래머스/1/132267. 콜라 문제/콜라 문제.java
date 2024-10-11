class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int emptyBottle = 0;
        while(n!=0){
            int newBottle = (n / a) * b;
            answer += newBottle;
            emptyBottle += (n % a);
            n = newBottle;
            if(emptyBottle >= a){
                answer+=b;
                n+=b;
                emptyBottle -= a;
            }
        }
        return answer;
    }
}