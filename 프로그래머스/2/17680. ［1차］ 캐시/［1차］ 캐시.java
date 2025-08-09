import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int time = 0;
        if (cacheSize == 0) return cities.length * 5;
        
        LinkedHashSet<String> cache = new LinkedHashSet<>();
        
        for (String city : cities){
            String key = city.toUpperCase();
            
            if (cache.contains(key)){
                time += 1;
                cache.remove(key);
                cache.add(key);
            }else{
                time += 5;
                if (cache.size() == cacheSize){
                    cache.remove(cache.iterator().next());
                }
                cache.add(key);
            }
            
        }
        return time;
    }
}

/*
지도에서 도시 이름을 검색 -> 해당 도시와 관련된 맛집 게시물 보여줌
성능 측정을 수행하였는데, 실행시간이 너무 오래 걸린다
캐시 크기를 얼마로 해야하지?
DB 캐시를 적용할 때 캐시 크기에 따른 실행시간 측정 프로그램을 작성하시오.
캐시 크기 -> 실행 시간 측정 
Least Recently Used 가장 오랫동안 안사용된 녀석. 

deque 활용 -> 존재하는지 조회시에 O(n), 양단 수정 O(1) 
LinkedHashSet 활용 -> 존재하는지 조회시에 O(1), 양단 수정 O(1)


힙에 존재O hit, hitCnt ++ , hitCnt 기준 minHeap 으로 구성, answer ++
힙에 존재X miss, heap.pop(), heap.add(city),  answer += 5
대소문자 구분 X -> 다 upper 해버리자.

*/