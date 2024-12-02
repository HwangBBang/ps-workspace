import java.util.*;


class Solution {
    public String[] solution(String[] strArr) {
        return Arrays.stream(strArr).filter(each -> !each.contains("ad")).toArray(String[]::new);
        
    }
    
}