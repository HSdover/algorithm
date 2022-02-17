package com.algorithm.programmers.lv2;

public class 괄호_변환 {
    public static void main(String[] args) {
        solution("()))((()");
    }

    public static String solution(String p) {
        String answer = "";

        char[] cp = p.toCharArray();
        int left = 0;
        int right = 0;
        String regex = "";
        for(int i = 0; i < cp.length; i++) {
            if(cp[i] == '(') {
                left++;
                regex += cp[i];
            }
            else {
                right++;
                regex += cp[i];
            }
            if(left == right) {
                StringBuilder r1 = new StringBuilder(regex.substring(0, regex.length()/2));
                StringBuilder r2 = new StringBuilder(regex.substring(regex.length()/2));
                System.out.println(r1);
                System.out.println(r2.reverse());

            }
        }
        return answer;
    }
}
