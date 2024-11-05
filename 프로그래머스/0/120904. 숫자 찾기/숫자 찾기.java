class Solution {
    public int solution(int num, int k) {
        int answer = 0;
        String[] nums = String.valueOf(num).split("");
        
        for(String s : nums){
            answer ++; 
            
            if (Integer.parseInt(s) == k){
                return answer;
            }
        }
        
        
        return -1;
    }
}