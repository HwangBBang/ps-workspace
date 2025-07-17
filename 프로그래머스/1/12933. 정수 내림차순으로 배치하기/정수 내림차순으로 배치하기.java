import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        String str = String.valueOf(n);
        String[] strs= str.split("");
        Arrays.sort(strs, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String s : strs){
            sb.append(s);    
        }
        answer = Long.parseLong(sb.toString());
        return answer;
    }
}