class Solution {
    public int solution(String my_string) {
        int answer = 0;
        String[] str = my_string.split("");
        
        String compareStr = "0123456789";
        for (String s : str){
            if(compareStr.contains(s)){
                answer += Integer.parseInt(s);
            }   
        }
        return answer;
    }
}