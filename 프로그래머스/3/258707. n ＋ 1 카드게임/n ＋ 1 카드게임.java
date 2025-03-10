import java.util.*;

class Solution {
    public int solution(int coin, int[] cards) {
        int N = cards.length + 1;
        Set<Integer> hand = new HashSet<>();
        Set<Integer> prepare = new HashSet<>();
        int life = 0, prepareLife = 0;
        int round = 1;
        for(int i=0;i<cards.length/3;i++) {
            int num = cards[i];
            if(hand.contains(N-num)) {
                hand.remove(N-num);
                life++;
            } else {
                hand.add(num);
            }
        }
        for(int i=cards.length/3;i<cards.length;i=i+2) {
            int[] newCard = {cards[i], cards[i+1]};
            for(int num : newCard) {
                if(hand.contains(N-num) && coin > 0) {
                    hand.remove(N-num);
                    life++;
                    coin--;
                } else if(prepare.contains(N-num)) {
                    prepare.remove(N-num);
                    prepareLife++;
                } else {
                    prepare.add(num);
                }
            }
            
            if(life == 0) {
                if(coin >= 2 && prepareLife > 0) {
                    coin -= 2;
                    prepareLife--;
                    life++;
                }
            }
            
            if(life == 0) {
                break;
            }
            
            life--;
            round++;
        }
        
        return round;
    }
    
    //Set<> 2개
    //손에 있는 카드들, 일단 손에 없는데 예비용 
    //라운드는 일단 돌리자 정답인가? (확인해봐야함)
    //남은 목숨 life
    //내부에서 쌍을 만들기 함
    //먼저 손 카드 SET에서 되는게 있는지 확인
    //있으면 가지고 옴(coin-1), 아니면 예비용에 있는지 봄(coin -2) => life++;
    //문제 -> 예비용은 -2짜리고 기존꺼는 -1짜리잖아
    //코인이 낭비되는거 아닐까
    //기존꺼에 있으면 가져다 씀
    //없으면 예비용에 있는지 확인
    //있으면 예비 life+1;
    //만약 life가 0이면 예비 목숨--하기(coin-2)
    
    //life를 하나 까고 없으면
    
    /**
    13만들기
    life 0 내부에 6 7이 있다. life++;
    life = 1 round 1
    3 2 / null / 1 10
    10 가능 예비에 넣어
    2 / 1 (2)
    life = 1;
    round 2
    2 / 1 / 5 9 (1)
    불가능 예비에 넣어
    2 / 1 5 9
    life(0)
    round 3
    2 / 1 5 9 / 8 12
    일단 손 카드에는 없음 안됨
    life가 0이네? 내부에서 찾아야해
    예비 목숨 가능 2
    life가 0이네? 예비 목숨 -- 1
    life = 0 coin  = 1
    round 4
    2 / 9 / 11 4
    손카드에 있네 life + 1
    예비 있네 예비 목숨 
    round 5
    끝
    **/
}