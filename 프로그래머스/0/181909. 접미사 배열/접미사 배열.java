import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        List<String> stack = new ArrayList<>();
        
        int len = my_string.length();
        for (int i = 1; i < len + 1; i ++){
            stack.add(my_string.substring(len-i,len));
        }
        
        Collections.sort(stack);
        String[] answer = stack.toArray(String[]::new);
        return answer;
    }
}
