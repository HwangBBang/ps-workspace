import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> answer = new ArrayList();
        int len = num_list.length;
        
        for(int i = 0; i < len; i += n){
            if (i >= len) break;
            answer.add(num_list[i]);
        }
        
        int[] result = answer.stream().mapToInt(Integer::intValue).toArray();
        return result;
    }
}