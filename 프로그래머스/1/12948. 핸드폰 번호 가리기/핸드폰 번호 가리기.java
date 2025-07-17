class Solution {
    public String solution(String phone_number) {
        
        String[] splited = phone_number.split("");
        
        StringBuilder sb = new StringBuilder();
        
        int n = splited.length;
        for (int i = 0; i < n-4; i ++){
            sb.append("*");    
        }
        
        sb.append(phone_number.substring(n-4));
        String answer = sb.toString();
        return answer;
    }
}