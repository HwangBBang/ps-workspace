import java.util.*;
class Solution {
    public int solution(int[] sides) {
        
        int max = Arrays.stream(sides).max().orElse(0);
        int sum = Arrays.stream(sides).sum();
        int otherSum = sum - max;
        if (otherSum <= max) {
            return 2;
        }

        return 1;
    }
}