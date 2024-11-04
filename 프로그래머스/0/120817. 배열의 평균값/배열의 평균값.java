import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        // Arrays.stream(numbers).average().orElse(0);
        
        int sum = Arrays.stream(numbers).sum();
        int len = numbers.length;
        
        double answer = (double) sum / len;
        return answer;
    }
}