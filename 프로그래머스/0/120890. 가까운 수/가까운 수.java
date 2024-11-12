import java.util.*;

class Solution {
    public int solution(int[] array, int n) {
        Arrays.sort(array);
        
        int min = Arrays.stream(array).map(d -> Math.abs(d - n)).min().orElse(0);
        
        int[] result = Arrays.stream(array).filter(num -> Math.abs(num -n ) == min).toArray();
        
        return result[0];
        
    }
}