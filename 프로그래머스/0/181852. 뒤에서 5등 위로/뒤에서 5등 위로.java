import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int len = num_list.length;
        Arrays.sort(num_list);
        
        int[] answer = Arrays.copyOfRange(num_list, 5, len);
        return answer;
    }
}