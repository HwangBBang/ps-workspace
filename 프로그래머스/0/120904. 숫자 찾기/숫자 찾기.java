class Solution {
    public int solution(int num, int k) {
        // int answer = 0;
//         String[] nums = String.valueOf(num).split("");
        
//         for(String s : nums){
//             answer ++; 
            
//             if (Integer.parseInt(s) == k){
//                 return answer;
//             }
//         }
        int idx = String.valueOf(num).indexOf(String.valueOf(k));
        if (idx == -1) {
            return idx;
        }
        return idx + 1;
    
    }
}