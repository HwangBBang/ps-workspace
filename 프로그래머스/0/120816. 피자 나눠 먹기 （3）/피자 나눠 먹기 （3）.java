class Solution {
    public int solution(int slice, int n) {
        int answer = (n + slice - 1) / slice ;
        return answer;
    }
}
