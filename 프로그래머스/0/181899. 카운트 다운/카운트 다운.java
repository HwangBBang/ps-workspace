import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int start_num, int end_num) {
        List<Integer> collect = IntStream.rangeClosed(end_num, start_num).boxed().collect(Collectors.toList());
        Collections.reverse(collect);
        int[] array = collect.stream().mapToInt(Integer::intValue).toArray();
        return array;
    }
}