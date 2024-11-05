import java.util.*;
class Solution {
    public int solution(int order) {
        String[] split = String.valueOf(order).split("");
        
        return (int) Arrays.stream(split).
            filter( s -> s.equals("3") || s.equals("6") || s.equals("9"))
            .count();
    }
}