// package baekjoon.silver;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/baekjoon/silver/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        double totalScore = 0;
        double cumulativePoint = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            double point = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if (!grade.equals("P")) {
                totalScore += point * getScore(grade);
                cumulativePoint += point;
            }
        }

        double gpa = totalScore / cumulativePoint;
        System.out.println(gpa);
    }

    static double getScore(String grade) {
        if ("A+".equals(grade))
            return 4.5;
        else if ("A0".equals(grade))
            return 4.0;
        else if ("B+".equals(grade))
            return 3.5;
        else if ("B0".equals(grade))
            return 3.0;
        else if ("C+".equals(grade))
            return 2.5;
        else if ("C0".equals(grade))
            return 2.0;
        else if ("D+".equals(grade))
            return 1.5;
        else if ("D0".equals(grade))
            return 1.0;
        else if ("F".equals(grade))
            return 0.0;

        return -1;
    }


}

/*
*/