import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a,map.getOrDefault(a,0)+1);
        map.put(b,map.getOrDefault(b,0)+1);
        map.put(c,map.getOrDefault(c,0)+1);
        map.put(d,map.getOrDefault(d,0)+1);
        
        int answer = 0;
        
        if (map.keySet().size() == 1){
            answer = a*1111;
        } else if (map.keySet().size() == 4){
            answer = Math.min(Math.min(a,b), Math.min(c,d));
        } else if (map.keySet().size() == 2) {
            if(map.get(map.get(a)) == 2){
                List<Integer> temp = new ArrayList<>(map.keySet());
                answer = (temp.get(0) + temp.get(1)) * Math.abs(temp.get(0) - temp.get(1));
            }
            else {
                List<Integer> temp = new ArrayList<>(map.keySet());
                if (map.get(temp.get(0)) == 3) {
                    int p = temp.get(0);
                    int q = temp.get(1);
                    answer = (p * 10 + q) * (p * 10 + q);
                }else{
                    int p = temp.get(1);
                    int q = temp.get(0);
                    answer = (p * 10 + q) * (p * 10 + q);
                }
                
            }
        }
            
        
        
         else if (map.keySet().size() == 3){
            List<Integer> temp = new ArrayList<>(map.keySet());
             if (map.get(temp.get(0)) == 2) {
                answer = temp.get(1) * temp.get(2);
            }else if (map.get(temp.get(1)) == 2){
                answer = temp.get(0) * temp.get(2);
            }else if (map.get(temp.get(3)) == 2){
                answer = temp.get(1) * temp.get(1);
            }

        }
        
        

        return answer;
    }
}