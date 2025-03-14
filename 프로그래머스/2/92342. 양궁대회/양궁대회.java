class Solution {
    private int[] answerIndex = new int[11]; 
    private int maxDiff = 0; // 최대 점수 차이
    private int N;
    private int[] info;

    public int[] solution(int n, int[] info) {
        N = n;
        this.info = info;
        dfs(0, 0, new int[11]);
        if (maxDiff == 0) return new int[]{-1}; // 이길 방법이 없을 경우
        return answerIndex;
    }

    private void dfs(int index, int sum, int[] count) {
        if (index == 10) { 
            if (sum < N) count[10] += (N - sum); 
            int diff = getScoreDiff(count); 
            if (diff > maxDiff) { 
                maxDiff = diff;
                answerIndex = count.clone(); 
            } else if(diff == maxDiff && diff != 0) {
                boolean flag = true;
                for(int i=10;i>=0;i--) {
                    if(answerIndex[i] == count[i]) continue;
                    flag = (answerIndex[i] < count[i]);
                    break;
                }
                if(flag) {
                    maxDiff = diff;
                    answerIndex = count.clone(); 
                }
            }
            count[10] = 0;
            return;
        }

        // 어피치보다 많이 맞혀서 해당 점수 가져가기
        if (sum + info[index] + 1 <= N) {
            count[index] = info[index] + 1;
            dfs(index + 1, sum + count[index], count);
            count[index] = 0; // 백트래킹 (이전 상태로 복구)
        }

        // 해당 점수 포기하고 그냥 넘기기
        dfs(index + 1, sum, count);
    }

    private int getScoreDiff(int[] count) {
        int lionScore = 0, apeachScore = 0;
        for (int i = 0; i < 11; i++) {
            if (count[i] > info[i]) lionScore += (10 - i);
            else if (info[i] > 0) apeachScore += (10 - i);
        }
        return lionScore - apeachScore;
    }
}
