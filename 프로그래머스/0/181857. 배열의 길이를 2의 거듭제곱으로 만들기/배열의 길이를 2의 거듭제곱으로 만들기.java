class Solution {
    public int[] solution(int[] arr) {
        
        int len = arr.length;
        
        int newLen = 1;
        
        while (newLen < len) newLen*=2;
        
        
        int[] answer = new int[newLen];

        System.arraycopy(arr,0,answer,0,len);
        
        return answer;
    }
}