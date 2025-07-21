import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Queue<String> cardsQueue1 = new ArrayDeque<>();
        for (String card : cards1) cardsQueue1.add(card);
        
        Queue<String> cardsQueue2 = new ArrayDeque<>();
        for (String card : cards2) cardsQueue2.add(card);
        
        
        for (String target : goal){
            if (!target.equals(cardsQueue1.peek()) && !target.equals(cardsQueue2.peek())){
                return "No";
            }
            
            if (!cardsQueue1.isEmpty() & target.equals(cardsQueue1.peek())){
                cardsQueue1.poll();
            }
            if (!cardsQueue2.isEmpty() & target.equals(cardsQueue2.peek())){
                cardsQueue2.poll();
            } 
            
        }
        return answer;
    }
}

/*

첫 번째 카드 뭉치 ["i", "drink", "water"]
두 번째 카드 뭉치 ["want", "to"]

*/