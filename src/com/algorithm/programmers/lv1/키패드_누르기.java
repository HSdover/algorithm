package com.algorithm.programmers.lv1;

public class 키패드_누르기 {

    public static void main(String[] args) {
        solution();
    }
    public static String solution() {
        String answer = "";
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        String hand = "right";

        //* 0 #을 10 11 12로 치환
        int nowL = 10, nowR = 12;
        for(int i = 0; i < numbers.length; i++) {
             if(numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer = answer + "L";
                nowL = numbers[i];
            }
            else if(numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer = answer + "R";
                nowR = numbers[i];
            }
            else if(numbers[i] == 2 || numbers[i] == 5 || numbers[i] == 8 || numbers[i] == 11) {
                 System.out.println("inininin");
                if(Math.abs(numbers[i] - nowL) < Math.abs(numbers[i] - (nowR - 2))) {
                    answer = answer + "L";
                    nowL = numbers[i];
                }
                else if(Math.abs(numbers[i] - nowL) > Math.abs(numbers[i] - (nowR - 2))) {
                    answer = answer + "R";
                    nowR = numbers[i];
                }
                else {
                    System.out.println("handhandhand");
                    if(hand.equals("right")) {
                        answer = answer + "R";
                        nowR = numbers[i];
                    }
                    else {
                        answer = answer + "L";
                        nowL = numbers[i];
                    }
                }
            }
            System.out.println(answer);
        }

        return answer;
    }
}
