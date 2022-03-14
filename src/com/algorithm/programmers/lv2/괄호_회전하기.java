package com.algorithm.programmers.lv2;

public class 괄호_회전하기 {
    public static void main(String[] args) {
        괄호_회전하기 t = new 괄호_회전하기();
        t.solution("[](){}");
    }

    public int solution(String s) {
        int answer = 0;

        for(int i = 0; i < s.length(); i++) {
            if(check(s))
                answer++;

            String sub = s.substring(0, 1);
            s = s.substring(1) + sub;
        }
        return answer;
    }

    public boolean check(String s) {
        while(s.length() != 0) {
            String s2 = s;
            s = s.replace("[]", "");
            s = s.replace("()", "");
            s = s.replace("{}", "");
            if(s.length() == s2.length())
                return false;
        }
        return true;
    }
//    public boolean check(StringBuilder sb) {
//        int l = 0, r = 0;
//        StringBuilder front = new StringBuilder();
//        StringBuilder back = new StringBuilder();
//
//        for(int i = 0; i < sb.length(); i++) {
//            if(r > l)
//                return false;
//
//            if(sb.charAt(i) == '[' || sb.charAt(i) == '{' || sb.charAt(i) == '(') {
//                l++;
//                front.append(sb.charAt(i));
//            }
//            else if(sb.charAt(i) == ']' || sb.charAt(i) == '}' || sb.charAt(i) == ')') {
//                r++;
//                if(sb.charAt(i) == ']')
//                    sb.setCharAt(i, '[');
//                else if(sb.charAt(i) == '}')
//                    sb.setCharAt(i, '{');
//                else if(sb.charAt(i) == ')')
//                    sb.setCharAt(i, '(');
//                back.append(sb.charAt(i));
//            }
//
//            if(r == l) {
//                if(!front.toString().equals(back.reverse().toString()))
//                    return false;
//                front = new StringBuilder();
//                back = new StringBuilder();
//                r = 0;
//                l = 0;
//            }
//        }
//        return true;
//    }
}
