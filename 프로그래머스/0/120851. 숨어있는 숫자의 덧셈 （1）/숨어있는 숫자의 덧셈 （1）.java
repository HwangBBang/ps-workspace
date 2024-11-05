class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split("");
        for (String s : str){
            if(s.matches("[0-9]")){
                answer += Integer.parseInt(s);
            }   
        }
        return answer;
    }
}