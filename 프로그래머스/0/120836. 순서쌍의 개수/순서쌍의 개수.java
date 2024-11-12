import java.util.stream.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;        
        int[] divisors = IntStream.rangeClosed(1, n).filter(i -> n % i == 0).toArray();
                
        
        return divisors.length;
    }
}