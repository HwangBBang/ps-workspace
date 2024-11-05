import java.util.*;
class Solution {
    public int[][] solution(int[] num_list, int n) {
        ArrayList<int[]> answer = new ArrayList<>();
        
        for (int i = 0; i < num_list.length; i += n){
            answer.add(Arrays.copyOfRange(num_list, i, i + n));
        }
        return answer.toArray(new int[answer.size()][]);
    }
}