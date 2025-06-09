class Solution {
    public double solution(int[] arr) {
        double answer = 0;
        int len = arr.length;
        int sum = 0;
        
        for (int elem : arr){
            sum += elem;
        }
        answer = (double)sum / len;
        return answer;
    }
}