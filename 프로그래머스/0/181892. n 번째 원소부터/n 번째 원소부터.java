import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        return Arrays.copyOfRange(num_list,n-1, len);
    
    }
}