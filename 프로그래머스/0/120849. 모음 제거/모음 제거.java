class Solution {
    public String solution(String my_string) {
        // String[] targets = {"a", "e", "i", "o", "u"};
        // for (String target : targets) {
        //     my_string = my_string.replace(target,"");
        // }
        
        my_string = my_string.replaceAll("[aeiou]","");
//        my_string = my_string.replaceAll("a|e|i|o|u","");
        return my_string;
    }
}