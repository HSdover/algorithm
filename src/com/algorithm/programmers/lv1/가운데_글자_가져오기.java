package com.algorithm.programmers.lv1;

public class 가운데_글자_가져오기 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String s = "abcde";
        String answer = "";

        if(s.length() % 2 == 0)
            answer = s.substring(s.length()/2-1, s.length()/2 + 1);
        else
            answer = s.substring(s.length()/2, s.length()/2 + 1 );
        return answer;
    }
}
