import java.util.*;
// import java.text.Format;
class Solution {
    public long solution(long n) {
        long answer = -1;
        double sqrt = Math.sqrt(n);
        
        if ((long)sqrt == sqrt) {
            long temp = (long) sqrt+1;
            answer = temp * temp;
        }
        return answer;
    }
}