class Solution {
    public String solution(String[] my_strings, int[][] parts) {
        String answer = "";
        for (int i = 0; i < my_strings.length; i ++){
            int[] part = parts[i]; 
            String my_string = my_strings[i];
            
            int start = part[0];
            int end = part[1];
            answer += my_string.substring(start,end+1);
        }
        return answer;
    }
}