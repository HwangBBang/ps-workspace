import java.util.*;

class Solution {
    static class Record{
        private String plateNum;
        private String enterTime;
        private String exitTime = "23:59";
        
        public Record(String plateNum, String enterTime){
            this.plateNum = plateNum;
            this.enterTime = enterTime;
        }
        
        public void setExitTime (String exitTime){
            this.exitTime = exitTime;
        }
        
        public int getMinute(){
            String[] exitSplited = this.exitTime.split(":");
            String[] enterSplited = this.enterTime.split(":");
             
            int minute = 
                (Integer.parseInt(exitSplited[0]) - Integer.parseInt(enterSplited[0])) * 60 
              + (Integer.parseInt(exitSplited[1]) - Integer.parseInt(enterSplited[1]));
            
            return minute;
        }
        
    }
    public int[] solution(int[] fees, String[] records) {
        List<Integer> result = new ArrayList<Integer>();
        
        Map<String, List<Record>> recordMap = new TreeMap<>();
        
        for (String record : records){
            String [] splited = record.split(" ");
            
            String time = splited[0];
            String plateNumber = splited[1];
            String flag = splited[2];
            
            if (flag.equals("IN")){
                if (!recordMap.containsKey(plateNumber)) {
                    List<Record> plateRecords = new ArrayList<>(); 
                    recordMap.put(plateNumber, plateRecords);
                }
                recordMap.get(plateNumber).add(new Record(plateNumber, time));
                
            } else if (flag.equals("OUT")){
                List<Record> plateRecords = recordMap.get(plateNumber); 
                plateRecords.get(plateRecords.size()-1).setExitTime(time);
            }
        }
        
        int defaultMinute = fees[0];
        int defaultFee = fees[1];
        int unitMinute = fees[2];
        int unitFee = fees[3];
        
        
        for (String plateNum: recordMap.keySet()){

            int sumMinute = 0;
            for (Record r : recordMap.get(plateNum)){
                sumMinute += r.getMinute(); 
            }
            
            int sum = defaultFee;
            sum += calculateFee(defaultMinute, unitMinute, unitFee, sumMinute);                
            result.add(sum);
        }
        
        int [] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
    
    static int calculateFee(
        int defaultMinute, 
        int unitMinute, 
        int unitFee,
        int usedMinute){
        
        if (defaultMinute > usedMinute) return 0;
        
        return (int) Math.ceil((double)(usedMinute - defaultMinute) / unitMinute) * unitFee;
    }
}

/*
[
"16:00 3961 IN", "18:00 3961 OUT",
"23:58 3961 IN", "23:59 3961 OUT"

"16:00 0202 IN",
"18:00 0202 OUT",

]
*/
