package com.algorithm.programmers.lv1;

public class 하샤드_수 {
    public static void main(String[] args) {
        solution(11);
    }

    public static boolean solution(int x) {
        boolean answer = true;

        int sum = 0;
        int copyX = x;
        while(copyX != 0) {
            sum += copyX % 10;
            copyX /= 10;
        }

        if(x % sum == 0)
            answer = true;
        else
            answer = false;

        return answer;
    }
}
