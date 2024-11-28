class Solution {
    public int solution(int[] arr, int idx) {
        for (int i = 0; i < arr.length; i ++ ){
            if (i >= idx && arr[i] == 1){
                return i;
            }
            continue;
        }
        
        return -1;
    }
}