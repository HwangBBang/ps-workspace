import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> boxed = new ArrayList();
        for (int num : arr){
            for (int i = 0; i < num; i ++){
                boxed.add(num);
            }
        }
        
        
        return boxed.stream().mapToInt(Integer::intValue).toArray();
    }
}