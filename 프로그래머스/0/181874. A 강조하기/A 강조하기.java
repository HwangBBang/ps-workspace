import java.util.*;

class Solution {
    public String solution(String myString) {
        String string = myString.replaceAll("a", "A");
        String[] strings = string.split("");

        ArrayList<String> answer = new ArrayList();

        for (String a : strings){
            if (!a.equals("A")){
                answer.add(a.toLowerCase());
            }else{
                answer.add(a);
            }
        }

        return String.join("", answer);
    }
}