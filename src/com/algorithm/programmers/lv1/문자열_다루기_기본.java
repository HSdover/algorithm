package com.algorithm.programmers.lv1;

public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        solution();
    }

    public static boolean solution() {
        String s = "9134";
        boolean answer = false;

        if(s.matches("^[0-9]*$") && (s.length() == 4 || s.length() == 6))
            answer = true;
        System.out.println(answer);
        return answer;
    }
}
