import java.util.*;

class Solution {
    public int solution(int n) {
        
        int sqrt = (int) Math.sqrt(n);
        int compare = (int) Math.pow(sqrt, 2);

        if (n == compare) {
            return 1;
        }

        return 2;
    }
}