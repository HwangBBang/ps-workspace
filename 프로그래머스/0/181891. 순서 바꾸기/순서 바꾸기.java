import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int len= num_list.length;
        ArrayList<Integer> front = new ArrayList();
        ArrayList<Integer> end = new ArrayList();
        
        for (int i = 0; i < len; i ++){
            if (i < n){
                front.add(num_list[i]);
            }else{
                end.add(num_list[i]);
            }
        }
        end.addAll(front);
        
        return end.stream().mapToInt(Integer::intValue).toArray();
    }
}