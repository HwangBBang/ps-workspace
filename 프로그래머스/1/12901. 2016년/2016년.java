// import java.util.*;
import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String solution(int a, int b) {
        String answer = "";
        
        LocalDate date = LocalDate.of(2016, a, b);
        
        DayOfWeek day = date.getDayOfWeek();
        answer = day.toString().substring(0,3);
        
        return answer;
    }
}