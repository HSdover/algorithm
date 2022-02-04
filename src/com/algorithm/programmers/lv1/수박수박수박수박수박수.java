package com.algorithm.programmers.lv1;

public class 수박수박수박수박수박수 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        int n = 3;
        String answer = "";

        for(int i = 0; i < n; i++) {
            if(i % 2 == 0)
                answer += "수";
            else
                answer += "박";
        }

        System.out.println(answer);
        return answer;
    }
}
