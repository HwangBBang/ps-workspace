class Solution {
    public String solution(String rsp) {
        String[] split = rsp.split("");
        StringBuilder sb = new StringBuilder();
        
        
        for (String k : split) {
            
            if (k.equals("2")) {
                sb.append("0");
            } else if (k.equals("5")) {
                sb.append("2");
            } else if (k.equals("0")) {
                sb.append("5");
            }
        }
            
        return sb.toString();
    }
}