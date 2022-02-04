package com.algorithm.programmers.lv1;

public class 문자열을_정수로_바꾸기 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        String s = "+1234";
        int answer = 0;

        System.out.println(s.substring(1));
        int pm = 1;
        if(s.charAt(0) == '+') {
            pm = 1;
            s = s.substring(1);
        }
        else if(s.charAt(0) == '-') {
            pm = -1;
            s = s.substring(1);
        }
        answer = Integer.parseInt(s);

        return answer * pm;
    }
}
