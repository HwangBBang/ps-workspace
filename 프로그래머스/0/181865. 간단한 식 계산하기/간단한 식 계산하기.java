class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        for (int i = 0; i < binomial.length(); i ++){
            
            char check = binomial.charAt(i);
            if (check == '+'||check == '*'||check == '-'){
                int a = Integer.parseInt(binomial.substring(0,i-1));
                int b = Integer.parseInt(binomial.substring(i+2));
                
                if (check == '+')         answer =  a + b;
                else if (check == '-')    answer =  a - b;
                else if (check == '*')    answer =  a * b;
            }
            
            
                
        }
            
        return answer;
    }
}