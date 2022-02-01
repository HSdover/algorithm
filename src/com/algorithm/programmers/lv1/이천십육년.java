package com.algorithm.programmers.lv1;

public class 이천십육년 {
    public static void main(String[] args) {
        solution();
    }
    public static String solution() {
        int a = 1;
        int b = 1;
        String answer = "";
        String[] dayW = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] day = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int sum = 0;
        for(int i = 0; i < a-1; i++)
            sum += day[i];
        sum += b;
        answer = dayW[sum % 7];
        System.out.println(answer);
//        for(int i = 1; i < 13; i++) {
//            for(int j = 1; j < 32; j++) {
//                // 요일 초기화
//                if(dayIdx == 7)
//                    dayIdx = 0;
//
//                if(i <= 7) {
//                    if(i == a && j == b) {
//                        answer = new StringBuilder(day[dayIdx++]);
//                        break;
//                    }
//                    else if(i == 2 && j == 29) {
//                        answer = new StringBuilder(day[dayIdx++]);
//                        break;
//                    }
//                    else if(i % 2 == 0 && j == 30) {
//                        answer = new StringBuilder(day[dayIdx++]);
//                        break;
//                    }
//                    else
//                        answer = new StringBuilder(day[dayIdx++]);
//                }
//                else {
//                    if(i == a && j == b) {
//                        answer = new StringBuilder(day[dayIdx++]);
//                        break;
//                    }
//                    else if(i % 2 == 1 && j == 30) {
//                        answer = new StringBuilder(day[dayIdx++]);
//                        break;
//                    }
//                    else
//                        answer = new StringBuilder(day[dayIdx++]);
//                }
//            }
//            if(i == a)
//                break;
//        }

        return answer;
    }
}
