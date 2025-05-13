import java.util.*;

class Solution {
    public String solution(String[] str_list, String ex) {
        StringBuilder sb = new StringBuilder();
        
        for (String str : str_list){
            if (isContain(str, ex) )continue; 
            sb.append(str);
        }
        
        return sb.toString();
    }
    
    static boolean isContain(String str, String ex){
        int sLen = str.length();
        int eLen = ex.length();
        
        for (int i = 0; i <= sLen-eLen; i++){
            if (ex.equals(str.substring(i,i+eLen))) return true;
        }
            
        return false;
    }
}