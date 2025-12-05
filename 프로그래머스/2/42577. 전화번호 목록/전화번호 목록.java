import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> prefixSet = new HashSet<>();
        for (String each : phone_book) prefixSet.add(each);

        for (String phonNum : phone_book) {
            for (int i = 1; i < phonNum.length() ; i++) {
                String prefix = phonNum.substring(0, i);
                if (prefixSet.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}