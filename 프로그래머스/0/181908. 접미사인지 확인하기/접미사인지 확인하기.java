import java.util.*;

class Solution {
    public int solution(String my_string, String is_suffix) {
        int answer = 0;
        int len = my_string.length();
        
        List<String> stack = new ArrayList<>();
        
        for (int i = 1; i <= len; i ++){
            stack.add(my_string.substring(len-i));
        }
        if (stack.contains(is_suffix)) answer = 1;
        
        return answer;
    }
}