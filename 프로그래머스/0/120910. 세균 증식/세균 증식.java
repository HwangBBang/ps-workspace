class Solution {
    public int solution(int n, int t) {
        int answer = n;
        
        for(int i = 0; i < t; i ++){
            answer = makeTwice(answer);
        }
        return answer;
    }
    
    private int makeTwice(int n){
        return n * 2;
    }
}