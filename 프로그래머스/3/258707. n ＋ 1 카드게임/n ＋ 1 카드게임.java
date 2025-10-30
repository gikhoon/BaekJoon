import java.util.*;

class Solution {
    Set<Integer> hand = new HashSet<>();
    Set<Integer> yet = new HashSet<>();
    public int solution(int coin, int[] cards) {
        int count = 0;
        int total = cards.length + 1;
        
        for (int i=0;i<cards.length/3;i++) {
            int card = cards[i];
            if(hand.contains(total - card)) {
                count++;
                hand.remove(card);
            } else {
                hand.add(card);
            }
        }
        
        int index = cards.length/3;
        int yetCount = 0;
        int round = 1;
        while(index < cards.length) {
            for(int i=0;i<2;i++) {
                int newCard = cards[index++];
                if(coin == 0) continue;
                //hand에서 있는지 확인
                if(hand.contains(total-newCard)) {
                    coin--;
                    count++;
                    hand.remove(total-newCard);
                } else if(yet.contains(total-newCard)) {
                    yetCount++;
                } else {
                    yet.add(newCard);
                }
            }
            
    
            if(round > count) {
                if(coin >= 2 && yetCount > 0) {
                    yetCount--;
                    coin-=2;
                    count++;
                }
            }
            
            if(round > count) {
                return round;
            }
            round++;
        }
        
        return round;
        
        //먼저 있는 카드로 가능한지 확인
    }
    
    //9 4
    //6 7
    /**
    1 3
    2
    **/
}