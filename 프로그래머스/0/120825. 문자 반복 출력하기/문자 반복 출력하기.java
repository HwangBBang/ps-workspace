import java.util.*;

class Solution {
    public String solution(String my_string, int n) {
        String[] str = my_string.split("");
        StringBuilder sb = new StringBuilder();        
        for (String s : str){
            sb.append(toMul(s,n));
        }
        
        return sb.toString();
    }
    
    private String toMul(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}