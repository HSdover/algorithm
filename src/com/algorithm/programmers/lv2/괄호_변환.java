package com.algorithm.programmers.lv2;

public class 괄호_변환 {
    public static void main(String[] args) {
        solution("()))((()");
    }

    private static String[] makeString(String p) {
        String[] uv = new String[2];

        int right = 0, left = 0;
        StringBuilder sb = new StringBuilder(p);
        for(int i = 0; i < p.length(); i++) {
            if(sb.charAt(i) == ')') {
                right++;
                uv[0] += sb.charAt(i);
            }
            else {
                left++;
                uv[0] += sb.charAt(i);
            }
        }

        return uv;
    }

    public static String solution(String p) {
        String answer = "";

        String u = new String();
        String v = new String();


        return answer;
    }
}
