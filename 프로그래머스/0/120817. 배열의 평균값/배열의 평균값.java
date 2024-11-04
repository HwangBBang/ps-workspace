import java.util.*;
class Solution {
    public double solution(int[] numbers) {
        int sum = Arrays.stream(numbers).sum();
        int len = numbers.length;
        
        double answer = (double) sum / len;
        return answer;
    }
}