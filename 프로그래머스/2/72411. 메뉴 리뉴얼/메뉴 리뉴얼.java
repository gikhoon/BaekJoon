import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static HashMap<Integer, Integer> size = new HashMap<>(); 
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        int max = course[course.length-1];
        for(String order : orders) {
            dfs(order, 0, "", max);
        }
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        
        int i=0;
        for(int co : course) {
            if(!size.containsKey(co) || size.get(co) == 1) continue;
            int maxSize = size.get(co);
            for (String key : keySet) {
                if(map.get(key) == maxSize && key.length() == co) answer.add(key);
            }
        }
        Collections.sort(answer);
        
        return answer.toArray(String[]::new);
    }
    
    private void dfs(String str, int index, String data, int maxLength) {
        if (data.length() == maxLength || index == str.length()) {
            if(data.length() < 2) return;
            char[] ch = data.toCharArray();
            Arrays.sort(ch);
            data = new String(ch);
            if(map.containsKey(data)){
                int count = map.get(data);
                map.put(data, count+1);
            } else {
                map.put(data, 1);
            }
            if(size.containsKey(data.length())){
                int a = size.get(data.length());
                size.put(data.length(), Math.max(a, map.get(data)));
            } else{
                size.put(data.length(), 1);
            }
            return;
        }
        String indexStr = String.valueOf(str.charAt(index));
        dfs(str, index+1,data+indexStr,maxLength);
        dfs(str, index+1,data,maxLength);
    }
}