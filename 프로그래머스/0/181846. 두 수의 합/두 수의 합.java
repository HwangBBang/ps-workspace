import java.math.*;

class Solution {
    public String solution(String a, String b) {
        BigInteger bigA = new BigInteger(a);
        BigInteger bigB = new BigInteger(b);
        String answer = String.valueOf(bigA.add(bigB));
        return answer;
    }
}