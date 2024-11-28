import java.util.*;


class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> temp = new ArrayList();
        
        for (int i = 1; i <= n; i ++){
            if(i % k == 0) temp.add(i);
            continue;
        }
        
        int[] answer = temp.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}