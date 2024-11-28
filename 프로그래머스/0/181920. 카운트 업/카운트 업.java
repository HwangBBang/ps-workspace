import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num , end_num).toArray();
    }
}