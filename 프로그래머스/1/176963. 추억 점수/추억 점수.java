import java.util.*;

class Solution {
    
    static Map<String, Integer> map = new HashMap<>();
    
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int[] answer = new int[photo.length];
        
        int size = name.length;
        
        for (int i = 0; i < size; i++){
            map.put(name[i],yearning[i]);
        }
        //
        
        for (int i = 0; i < photo.length; i ++){
            answer[i] = getPoint(photo[i]);
        }
        
        return answer;
    }
    
    static int getPoint(String[] names){
        int answer = 0;
        for (String name : names){
            answer += map.getOrDefault(name, 0);
        }
        return answer;
    }
}


/*

사진별 -> 추억 점수



추억 점수 = sum(인물의 점수)
=> map

예를 들어 사진 속 인물의 이름이 ["may", "kein", "kain"]이고 각 인물의 그리움 점수가 [5점, 10점, 1점]일 때 해당 사진의 추억 점수는 16(5 + 10 + 1)점


다른 사진 속 인물의 이름이 ["kali", "mari", "don", "tony"]이고 ["kali", "mari", "don"]의 그리움 점수가 각각 [11점, 1점, 55점]]이고, "tony"는 그리움 점수가 없을 때, 이 사진의 추억 점수는 3명의 그리움 점수를 합한 67(11 + 1 + 55)점입니다.

그리워하는 사람의 이름을 담은 문자열 배열 name, 각 사람별 그리움 점수를 담은 정수 배열 yearning, 각 사진에 찍힌 인물의 이름을 담은 이차원 문자열 배열 photo가 매개변수로 주어질 때, 사진들의 추억 점수를 photo에 주어진 순서대로 배열에 담아 return하는 solution 함수를 완성해주세요.
*/