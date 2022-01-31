package com.algorithm.programmers.lv1;

public class 약수의_개수와_덧셈 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int left = 24;
        int right = 27;

        int sum = 0;
        for(int i = left; i <= right; i++) {
            int val = (int)Math.sqrt(i);
            if(Math.pow(val, 2) == i)
                sum -= i;
            else
                sum += i;
        }
        return sum;
    }
}
