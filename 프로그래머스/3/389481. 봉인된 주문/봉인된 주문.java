import java.util.*;

class Solution {
    static HashMap<Integer, List<String>> withL = new HashMap<>();
    public String solution(long n, String[] bans) {
        for(int i=1;i<=11;i++) {
            withL.put(i, new ArrayList<>());
        }
        for(String ban : bans) {
            withL.get(ban.length()).add(ban);
        }
        int i;
        for(i=1;i<=11;i++) {
            long count = countMax(i) - withL.get(i).size();
            if(count >= n) break;
            n -= count;
        }
        return findAnswer(n,i,withL.get(i),0, "");
    }
    
    private String findAnswer(long n, int banLength, List<String> bans, int index, String answer) {
        System.out.println(banLength+" "+answer);
        if (answer.length() == banLength) return answer;
        
        HashMap<Character, List<String>> withC = new HashMap<>();
        for (int i=0;i<26;i++) {
            withC.put((char)('a'+i), new ArrayList<>());
        }
        for(String ban : bans) {
            withC.get(ban.charAt(index)).add(ban);
        }
        long max = countMax(banLength - index - 1);
        int i;
        for(i=0;i<26;i++) {
            long count = max - withC.get((char)('a'+i)).size(); 
            if(count >= n) break;
            n -= count;
        }
        return findAnswer(n, banLength, withC.get((char)('a'+i)), index+1, answer + (char)('a'+i));
    }
    
    private long countMax(int depth) {
        return (long) Math.pow(26, depth);
    }
    
    //일단 밴을 글자 수로 분할
    //a,b,c -> 1
    //갯수가 넘치면 그 내부에서 또 분할
    
    //1 -> 26 뺸다
    //7362
    //2 -> 26 * 26 = 676 뺸다
    // 6686 / 3 -> 17576 작으니까 3짜리를 분할
    // 1자리 a인 모음 1자리 b 모음....
    // 676 * 10 > 6686 이니까 j다
    //j 내에서 또 26개로 분할
}