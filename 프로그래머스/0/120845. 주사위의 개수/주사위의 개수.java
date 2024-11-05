class Solution {
    public int solution(int[] box, int n) {
        int answer = 1;
        
        for (int len : box){
            answer *= len/n;
        }
        return answer;
    }
}