
import java.util.*;

class Solution{
    public int solution(int a, int d, boolean[] included) {
        
        ArrayList<Integer> answerList = new ArrayList<>();
        
        for (int cnt = 0; cnt < included.length; cnt++) {
            if(included[cnt]) answerList.add(a + d*cnt);
        }

        return answerList.stream().mapToInt(Integer:: intValue).sum();
    }
}