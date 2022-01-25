package com.algorithm.programmers.lv1;

public class 내적 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] a = {1,2,3,4};
        int[] b = {-3,-1,0,2};
        int answer = 1234567890;

        int sum = 0;
        for(int i = 0; i < a.length; i++)
            sum += a[i] * b[i];
        answer = sum;
        System.out.println(sum);
        return answer;
    }
}
