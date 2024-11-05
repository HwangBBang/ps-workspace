import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n) {
        
        return (int)IntStream.rangeClosed(1,n).filter(k -> isTarget(k)).count();
    }
    private boolean isTarget(int n){
        int cnt = 0; 
        int i = 0;
        
        while(i <= n){
            i ++;
            if(cnt >= 3 ) return true;
            if(n % i == 0) cnt ++;
        }
        return false;
    }
}