package com.algorithm.programmers.lv1;

public class 키패드_누르기 {

    public static void main(String[] args) {
        solution();
    }

    // 직선 거리가 아니라 칸 수를 구해야함.
//    public static double distance(int pos, int btn) {
//        int[][] pad = new int[4][3];
//        if(pos == 0)
//            pos = 11;
//        System.out.println("들어옴");
//        System.out.println(pos);
//        int num = 1;
//        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
//        for(int i = 0; i < 4; i++) {
//            for(int j = 0; j < 3; j++) {
//                pad[i][j] = num;
//                if(num == pos) {
//                    x1 = j;
//                    y1 = i;
//                }
//                else if(num == btn) {
//                    x2 = j;
//                    y2 = i;
//                }
//                num++;
//            }
//        }
//        return Math.sqrt((x1*x1 + y1*y1) + (x2*x2 + y2*y2));
//    }

    //칸 수 구하기
//    public static int distance(int pos, int btn) {
//        int[][] pad = new int[4][3];
//        if(pos == 0)
//            pos = 11;
//        if(btn == 0)
//            btn = 11;
//        int num = 1;
//        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
//        for(int i = 0; i < 4; i++) {
//            for(int j = 0; j < 3; j++) {
//                pad[i][j] = num;
//                if(num == pos) {
//                    x1 = j;
//                    y1 = i;
//                }
//                else if(num == btn) {
//                    x2 = j;
//                    y2 = i;
//                }
//                num++;
//            }
//        }
//        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
//    }

//    public static String solution() {
//        String answer = "";
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//        String hand = "left";
//
//        //* 0 #을 10 11 12로 치환
//        int nowL = 10, nowR = 12;
//        for(int i = 0; i < numbers.length; i++) {
//             if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
//                answer = answer + "L";
//                nowL = numbers[i];
//            }
//            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
//                answer = answer + "R";
//                nowR = numbers[i];
//            }
//            else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 0) {
//                if(distance(numbers[i], nowL) < distance(numbers[i], nowR)) {
//                    answer = answer + "L";
//                    nowL = numbers[i];
//                }
//                else if(distance(numbers[i], nowL) > distance(numbers[i], nowR)) {
//                    answer = answer + "R";
//                    System.out.println("확인용 " + i + " " + numbers[i]);
//                    nowR = numbers[i];
//                }
//                else {
//                    if(hand.equals("right")) {
//                        answer = answer + "R";
//                        nowR = numbers[i];
//                    }
//                    else {
//                        answer = answer + "L";
//                        nowL = numbers[i];
//                    }
//                }
//            }
//        }
//        System.out.println(answer);
//        return answer;
//    }

    public static String solution() {
        String answer = "";
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        String hand = "left";

        //* 0 #을 10 11 12로 치환
        int nowL = 10, nowR = 12;

        for(int num : numbers) {
            if(num == 0) num = 11;
            switch (num % 3) {
                case 0 :
                    answer = answer + "R";
                    nowR = num;
                    break;
                case 1 :
                    answer = answer + "L";
                    nowL = num;
                    break;
                case 2 :
                    int disR = Math.abs((nowR - 1) - (num - 1)) / 3 + Math.abs((nowR - 1) - (num - 1)) % 3;
                    int disL = Math.abs((nowL - 1) - (num - 1)) / 3 + Math.abs((nowL - 1) - (num - 1)) % 3;
                    if(disR > disL) {
                        answer = answer + "L";
                        nowL = num;
                    }
                    else if(disR < disL) {
                        answer = answer + "R";
                        nowR = num;
                    }
                    else {
                        if(hand.equals("right")) {
                            answer = answer + "R";
                            nowR = num;
                        }
                        else {
                            answer = answer + "L";
                            nowL = num;
                        }
                    }
                }
            }
        return answer;
    }
}
