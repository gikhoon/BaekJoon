import java.util.*;

class Solution {
    static List<Integer>[][][][] count = new ArrayList[4][3][3][3];
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        count[i][j][k][l] = new ArrayList<>();
                    }
                }
            }
        }
        
        for(int i=0;i<info.length;i++) {
            String[] split = info[i].split(" ");
            int[] d = new int[5];
            d[0] = findLang(split[0]);
            d[1] = findPos(split[1]);
            d[2] = findLev(split[2]);
            d[3] = findFood(split[3]);
            d[4] = Integer.parseInt(split[4]);
            putcount(d[0], d[1], d[2], d[3], d[4]);
        }
        
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        Collections.sort(count[i][j][k][l]);
                    }
                }
            }
        }
        
        int i=0;
        for(String q : query) {
            String[] str = q.split(" ");
            List<Integer> nums = count[findLang(str[0])][findPos(str[2])][findLev(str[4])][findFood(str[6])];
            answer[i++] = getCount(nums, Integer.parseInt(str[7]));
        }
        
        // 3 * 2 * 2 * 2 * 100,000
        // 0 전부로 처리
        return answer;
    }
    
    private int getCount(List<Integer> nums, int num) {
        int left = 0;
        int right = nums.size();
        
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums.get(mid) >= num) {
                right = mid; 
            } else {
                left = mid + 1; 
            }
        }

        return nums.size() - left;
    }
    
    private void putcount(int a, int b, int c, int d, int e) {
        count[0][0][0][0].add(e);
        count[a][0][0][0].add(e);
        count[0][b][0][0].add(e);
        count[0][0][c][0].add(e);
        count[0][0][0][d].add(e);
        count[a][b][0][0].add(e);
        count[a][0][c][0].add(e);
        count[a][0][0][d].add(e);
        count[0][b][c][0].add(e);
        count[0][b][0][d].add(e);
        count[0][0][c][d].add(e);
        count[a][b][c][0].add(e);
        count[a][b][0][d].add(e);
        count[a][0][c][d].add(e);
        count[0][b][c][d].add(e);
        count[a][b][c][d].add(e);
    }
    
    private int findLang(String a){
        switch(a){
            case "-":
                return 0;
            case "cpp":
                return 1;
            case "java":
                return 2;
            default:
                return 3;
        }
    }
    
    private int findPos(String a){
        switch(a){
            case "-":
                return 0;
            case "backend":
                return 1;
            default:
                return 2;
        }
    }
    
    private int findLev(String a){
        switch(a){
            case "-":
                return 0;
            case "junior":
                return 1;
            default:
                return 2;
        }
    }
    
    private int findFood(String a){
        switch(a){
            case "-":
                return 0;
            case "chicken":
                return 1;
            default:
                return 2;
        }
    }
}