package com.algorithm.programmers.lv1;

public class 짝수와_홀수 {
    public static void main(String[] args) {
        solution(3);
    }

    public static String solution(int num) {
        String answer = "";

        // 삼항연산자로도 가능
        if(num % 2 == 0)
            answer = "Even";
        else
            answer = "Odd";

        return answer;
    }
}
