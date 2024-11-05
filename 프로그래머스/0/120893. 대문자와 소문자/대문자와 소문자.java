class Solution {
    public String solution(String my_string) {
        
        String[] string = my_string.split("");

        StringBuilder sb = new StringBuilder();
        
        for (String s : string){
            if (s.equals(s.toLowerCase())) {
                sb.append(s.toUpperCase());
            }else if(s.equals(s.toUpperCase())){
                sb.append(s.toLowerCase());    
            }
        }
        return sb.toString();
    }
}