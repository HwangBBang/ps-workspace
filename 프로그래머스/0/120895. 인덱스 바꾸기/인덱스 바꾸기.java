import java.util.*;

class Solution {
    public String solution(String my_string, int num1, int num2) {
        String[] str = my_string.split("");
        
        String remNum1 = str[num1];
        str[num1] = str[num2];
        str[num2] = remNum1;
        
        return String.join("", str);
    }
}