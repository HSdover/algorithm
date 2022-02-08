package com.algorithm.programmers.lv1;

public class 평균_구하기 {
    public static void main(String[] args) {
        solution();
    }

    public static double solution() {
        int[] arr = {1,2,3,4};
        double answer = 0;

        int sum = 0;
        for(int val : arr)
            sum += val;

        answer = (double) sum / arr.length;
        return answer;
    }
}
