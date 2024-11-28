class Solution {
    public int solution(int[] num_list) {
        int numSum = 0;
        int numProd = 1;
        
        for (int i = 0; i < num_list.length; i++){
            numSum += num_list[i];
            numProd *= num_list[i];
        }
        
        int squreNumSum = numSum * numSum;
        if (numProd < squreNumSum){
            return 1;
        }
        return 0;
    }
}