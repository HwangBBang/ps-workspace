import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int [2];
        
        Set<Integer> lotto = new HashSet<>();
        
        int unKnown = 0;
        int correct = 0;
        
        for (int i = 0; i < lottos.length; i ++){
            if (lottos[i] == 0) unKnown ++;
            lotto.add(lottos[i]);
        }
    
        for (int i = 0; i < win_nums.length; i ++){
            if (lotto.contains(win_nums[i])) correct ++;
        }
        answer[0] = getRank(correct + unKnown);
        answer[1] = getRank(correct);
        
        return answer;
    }
    
    static int getRank(int correctCount){
        if (correctCount < 2) return 6;
        return 7-correctCount;
        
    }
}