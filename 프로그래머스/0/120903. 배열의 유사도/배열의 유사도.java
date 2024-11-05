import java.util.*;

class Solution {
    public int solution(String[] s1, String[] s2) {
        HashSet<String> set1 = new HashSet<>(List.of(s1));
        HashSet<String> set2 = new HashSet<>(List.of(s2));
        
        return (int) set1.stream().filter(s -> set2.contains(s)).count();
    }
}