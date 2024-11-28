class Solution {
    public int solution(int[] num_list) {
        int answer;
        int size = num_list.length;
        
        if(size >= 11){
           answer = 0;
           for (int num : num_list){
               answer += num;
           }
        }
        else{
            answer = 1;   
            for (int num : num_list){
               answer *= num;
           }
        }
        return answer;
    }
}