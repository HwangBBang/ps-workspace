import java.util.*;

class Solution {
    public String solution(String myString) {
        String answer = "";
        int len = myString.length();
        
        StringBuilder sb = new StringBuilder(myString);
        
        for(int i = 0; i < len ; i ++){
            if (sb.charAt(i) < 'l'){
                sb.setCharAt(i,'l');
            }
        }
        
        return sb.toString();
    }
}
// abcdefghijkl