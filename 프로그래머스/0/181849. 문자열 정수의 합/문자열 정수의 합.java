import java.util.*;


class Solution {
    public int solution(String num_str) {
        String[] nums = num_str.split("");
        
        int answer = Arrays.stream(nums).mapToInt(Integer::parseInt).sum();
        
        return answer;
    }
}