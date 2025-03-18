class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int[] downData = new int[50];
        for(int i=0;i<24;i++) {
            server -= downData[i];
            int needServer = players[i] / m;
            if(server < needServer) {
                downData[i+k] = needServer - server;
                answer += (needServer - server);
                server = needServer;
            }
        }
        return answer;
    }
    
    //24짜리를 만들어서
    //
}