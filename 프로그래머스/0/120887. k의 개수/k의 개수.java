import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int i, int j, int k) {
        String target = String.valueOf(k);
        
        return (int)IntStream.rangeClosed(i,j)
            .mapToObj(num -> String.valueOf(num))
            .mapToInt(s -> s.length() - s.replace(target,"").length())
            .sum();
            // .filter(str -> str.contains(String.valueOf(k)))
            // .count();
    }
}