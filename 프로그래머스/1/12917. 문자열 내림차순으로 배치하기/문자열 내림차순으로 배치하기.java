import java.util.*;

class Solution {
    public String solution(String s) {
        
        String [] strs = s.split("");
        Arrays.sort(strs, Collections.reverseOrder());
        
        StringBuilder sb = new StringBuilder();
        for (String each: strs){
            sb.append(each);
        }
        String answer = sb.toString();
        return answer;
    }
}