import java.util.*;
import java.util.stream.*;
// import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        int sum = IntStream.range(0,n+1)
            .filter(i -> i % 2 == 0)
            .sum();
        
        return sum;
    }
}