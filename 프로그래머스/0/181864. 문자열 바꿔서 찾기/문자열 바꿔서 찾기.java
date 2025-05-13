import java.util.*;

class Solution {
    public int solution(String myString, String pat) {
        
        StringBuilder sb = new StringBuilder(myString);
        for (int i = 0; i < sb.length(); i ++){
            if(sb.charAt(i) == 'A') sb.setCharAt(i,'B');
            else if(sb.charAt(i) == 'B') sb.setCharAt(i,'A');
        }
        myString = sb.toString();
        
        int pLen = pat.length();
        int sLen = myString.length();
        
        for (int i = 0; i <= sLen-pLen; i++){
            if (pat.equals(myString.substring(i,i+pLen))) return 1;
        }
        
        
        return 0;
    }
}

