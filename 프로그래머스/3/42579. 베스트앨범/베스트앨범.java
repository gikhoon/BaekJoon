import java.util.*;

class Album implements Comparable<Album>{
    int index;
    int plays;
    
    public Album(int index, int plays) {
        this.index = index;
        this.plays = plays;
    }
    
    @Override
    public int compareTo(Album a) {
        if (plays == a.plays) {
            return this.index - a.index;
        }
        return a.plays - this.plays;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        HashMap<String, Integer> playTotal = new HashMap<>();
        HashMap<String, List<Album>> albums = new HashMap<>();
        
        for(int i=0;i<genres.length;i++) {
            if (!playTotal.containsKey(genres[i])) {
                playTotal.put(genres[i], plays[i]);
                List<Album> newAlbum = new ArrayList<>();
                newAlbum.add(new Album(i, plays[i]));
                albums.put(genres[i], newAlbum);
            } else {
                playTotal.put(genres[i], playTotal.get(genres[i]) + plays[i]);
                List<Album> list = albums.get(genres[i]);
                list.add(new Album(i, plays[i]));
                albums.put(genres[i], list);
            }
        }
        
        List<String> keys = new ArrayList<>(playTotal.keySet());
        keys.sort((o1, o2) -> playTotal.get(o2).compareTo(playTotal.get(o1)));
        
        int i=0;
        for(String key : keys){
            List<Album> al = albums.get(key);
            Collections.sort(al);
            int count = 0;
            for(Album a : al) {
                if(count > 1) break;
                answer.add(a.index);
                count++;
            }
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
        
        //HashMap -> 장르 : 총 plays;
        //HashMap -> 장르 : 앨범 리스트
        
    }
}