class Solution {
    public int solution(int[] num_list) {
        String odds = "";
        String evens = "";
        for (int num : num_list){
            if (num % 2 == 1) odds += num;
            else evens += num;
        }
        
        
        return Integer.parseInt(odds) + Integer.parseInt(evens);
    }
}