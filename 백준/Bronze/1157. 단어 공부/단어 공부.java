import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Map<String, Integer> map = new HashMap<>();

        String str = sc.nextLine();
        String[] split = str.split("");

        for (String s : split) {
            s = s.toUpperCase();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }


        int maxCount = 0;
        String answerKey = "";
        boolean isDup = false;


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (maxCount < value) {
                maxCount = Math.max(maxCount, value);
                answerKey = key;
                isDup = false;
            } else if (maxCount == value) {
                isDup = true;
            }
        }


        if (!isDup) {
            System.out.println(answerKey);
        } else {
            System.out.println("?");
        }
    }
}
