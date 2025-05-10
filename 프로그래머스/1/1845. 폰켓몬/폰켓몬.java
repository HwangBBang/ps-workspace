import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i ++){
            temp.add(nums[i]);
        }
        Set<Integer> setNums = new HashSet<>(temp);
        
        int totalCount = nums.length;
        int typeCount = setNums.size();
        
        int selectCount = totalCount / 2;
        
        if (typeCount <= selectCount) return typeCount;
        
        return selectCount;
    }
}
