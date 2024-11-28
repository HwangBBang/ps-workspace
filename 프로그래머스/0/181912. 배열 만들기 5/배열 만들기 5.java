import java.util.*;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        
        String[] array = Arrays.stream(intStrs).map(each -> each.substring(s, s + l)).toArray(String[]::new);
        int[] answer = Arrays.stream(array).mapToInt(Integer::parseInt).filter(n -> n > k).toArray();
        return answer;
        
    }
}