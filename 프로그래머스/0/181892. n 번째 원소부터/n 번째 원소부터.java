import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        ArrayList<Integer> answer = new ArrayList();
        
        for (int i = n-1; i < len; i ++){
            answer.add(num_list[i]);
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}