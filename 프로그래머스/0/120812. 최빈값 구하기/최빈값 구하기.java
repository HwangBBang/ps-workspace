import java.util.stream.*; 
import java.util.*; 


class Solution {
    public int solution(int[] array) {
    
        Map<Integer, Long> frequencyMap 
            = Arrays.stream(array).boxed().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        
        long maxFrequency = frequencyMap.values().stream().max(Long::compare).orElse(0L);
        
        // 3. 최빈값이 여러 개인지 확인
        List<Integer> modes = frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxFrequency)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        // 4. 최빈값이 여러 개면 -1을 반환, 그렇지 않으면 최빈값 반환
        return modes.size() > 1 ? -1 : modes.get(0);

        
    }
}