package com.algorithm.programmers.lv1;

public class 음양_더하기 {

    public static void main(String[] args) {
        solution();
    }
    public static int solution() {
        int[] absolutes = {4,7,12};
        boolean[] signs = {true,false,true};
        int answer = 123456789;

        int sum = 0;
        for(int i = 0; i < absolutes.length; i++) {
            if(signs[i])
                sum += absolutes[i];
            else
                sum -= absolutes[i];
        }
        answer = sum;
        return answer;
    }
}
