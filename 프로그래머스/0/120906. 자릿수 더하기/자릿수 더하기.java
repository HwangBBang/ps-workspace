class Solution {
    public int solution(int n) {
        int answer = 0;
        String[] split = String.valueOf(n).split("");
        for (String e : split){
            answer += Integer.parseInt(e);
        }

        return answer;
        
        
    }
}