package com.algorithm.programmers.lv1;

public class 두_정수_사이의_합 {
    public static void main(String[] args) {
        solution();
    }

    public static long solution() {
        int a = 3;
        int b = 5;
        long answer = 0;

        int smallNum = 0;
        int bigNum = 0;

        if(a > b) {
            smallNum = b;
            bigNum = a;
        }
        else {
            smallNum = a;
            bigNum = b;
        }
        for(int i = smallNum; i <= bigNum; i++)
            answer += i;

        return answer;
    }
}
