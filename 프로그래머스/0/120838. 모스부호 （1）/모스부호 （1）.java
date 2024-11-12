import java.util.*;

class Solution {
    public String solution(String letter) {
        String[] origins = letter.split(" ");
        StringBuilder sb = new StringBuilder();
        Map<String, String> morse = new HashMap<>() {{
            put(".-", "a"); put("-...", "b"); put("-.-.", "c"); put("-..", "d");
            put(".", "e"); put("..-.", "f"); put("--.", "g"); put("....", "h");
            put("..", "i"); put(".---", "j"); put("-.-", "k"); put(".-..", "l");
            put("--", "m"); put("-.", "n"); put("---", "o"); put(".--.", "p");
            put("--.-", "q"); put(".-.", "r"); put("...", "s"); put("-", "t");
            put("..-", "u"); put("...-", "v"); put(".--", "w"); put("-..-", "x");
            put("-.--", "y"); put("--..", "z");
        }};

        for (String origin : origins) {sb.append(morse.get(origin));}

        return sb.toString();
    }
}