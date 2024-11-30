import java.time.*;

class Solution {
    public int solution(int[] date1, int[] date2) {
        LocalDate d1 = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate d2 = LocalDate.of(date2[0], date2[1], date2[2]);

        if(d1.isBefore(d2)){
            return 1;
        }
        return 0;
    }
}

// [2021, 12, 28]	[2021, 12, 29] -> 1
// [2020, 12, 28]	[2021, 12, 29] -> 1
// [2021, 12, 28]	[2021, 11, 29] -> 0
// [1024, 10, 24]	[1024, 10, 24] -> 0
