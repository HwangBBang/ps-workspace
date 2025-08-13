import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        Map<String, Integer> strMap1 = new HashMap<>();
        Map<String, Integer> strMap2 = new HashMap<>();
        
        mapping(str1, strMap1);
        mapping(str2, strMap2);
        
        List<String> keyList = new ArrayList<>();
            
        for (String key : strMap1.keySet()){
            if (!keyList.contains(key))keyList.add(key);
        }
        for (String key : strMap2.keySet()){
            if (!keyList.contains(key))keyList.add(key);
        }
        answer = getJacard(keyList, strMap1, strMap2);
        
        return answer;
    }
    
    static int getJacard(
        List<String> list, 
        Map<String, Integer> map1, 
        Map<String, Integer> map2){
        if (map1.size() == 0 && map2.size() == 0) return 65536;
        
        int asCnt = 0, unionCnt = 0;
        
        for (String key : list){
            int each1 = map1.getOrDefault(key,0);
            int each2 = map2.getOrDefault(key,0);
            
            asCnt += Math.min(each1,each2);
            unionCnt += Math.max(each1,each2);
        }
        
        double res = ((double) asCnt / unionCnt)* 65536; 
        return (int)res;
    }
    
    static void mapping(String str, Map<String, Integer> strMap){
        for (int i = 0; i < str.length()-1; i ++){
            String temp = str.substring(i,i+2).toUpperCase();
            if(containOthers(temp)) 
                strMap.put(temp, strMap.getOrDefault(temp, 0) + 1);
        }
    }
    
    static boolean containOthers(String s){
        char[] cs = s.toCharArray();
        for (char c : cs){
            if (!Character.isUpperCase(c)) return false;
        }
        return true;
    }
}

/*
사용자들이 편리하게 다양한 뉴스를 찾아볼 수 있도록 문제점을 개선하는 업무를 맡게 되었다.

개발의 방향을 잡기 위해 튜브는 우선 최근 화제가 되고 있는 "카카오 신입 개발자 공채" 관련 기사를 검색해보았다.

카카오 첫 공채..'블라인드' 방식 채용
카카오, 합병 후 첫 공채.. 블라인드 전형으로 개발자 채용
카카오, 블라인드 전형으로 신입 개발자 공채
카카오 공채, 신입 개발자 코딩 능력만 본다
카카오, 신입 공채.. "코딩 실력만 본다"
카카오 "코딩 능력만으로 2018 신입 개발자 뽑는다"

기사의 제목을 기준으로 나뉘는 걸 발견했다.
"블라인드 전형" 기사
"코딩 테스트" 기사 

튜브는 이들을 각각 묶어서 보여주자

-> 묶는 기준을 정하자 
-> "자카드 유사도"라는 방법


자카드 유사도는 집합 간의 유사도 검사 방법

두 집합 A, B 사이의 자카드 유사도 J(A, B)는 두 집합의 교집합 크기를 두 집합의 합집합 크기로 나눈 값으로 정의된다.

두 집합의 교집합 크기 / 두 집합의 합집합 크기 

합 A와 집합 B가 모두 공집합일 경우, J(A, B) = 1로 정의한다.

자카드 유사도는 원소의 중복을 허용하는 다중집합에 대해서 확장할 수 있다. 

다중집합 A는 원소 "1"을 3개 가지고 있고, 
다중집합 B는 원소 "1"을 5개 가지고 있다고 하자. 

교집합 A ∩ B는 원소 "1"을 min(3, 5)인 3개 
합집합 A ∪ B는 원소 "1"을 max(3, 5)인 5개

다중집합 A = {1, 1, 2, 2, 3} 
다중집합 B = {1, 2, 2, 4, 5}

교집합 A ∩ B = {1, 2, 2}, 
합집합 A ∪ B = {1, 1, 2, 2, 3, 4, 5}, 

교집합 min (1 은 2개 , 1 은 1개 ) -> 1 
합집합 max (1 은 2개 , 1 은 1개 ) -> 2

교집합 min (2 은 2개 , 2 은 2개 ) -> 2
합집합 max (2 은 2개 , 2 은 1개 ) -> 2

교집합 min (3 은 0개 , 3 은 1개 ) -> 0
합집합 max (3 은 0개 , 3 은 1개 ) -> 1



자카드 유사도 J(A, B) = 3/7, 약 0.42가 된다.

*/