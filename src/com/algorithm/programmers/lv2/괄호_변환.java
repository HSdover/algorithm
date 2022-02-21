package com.algorithm.programmers.lv2;

public class 괄호_변환 {
    public static void main(String[] args) {
        solution("()))((()");
    }

    // 그냥 문제에 주어진 조건을 잘 읽고 옮기면 되는데 혼자 고민에 빠져서 이틀이나 풀었음.. 쉬운 문제인데.. 문제를 잘 읽자
    public static String recusive(StringBuilder w) {
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();
        // 올바른 문자열 판별 변수
        int right = 0, left = 0;
        boolean ok = true;
        for(int i = 0; i < w.length(); i++) {
            if(w.charAt(i) == ')') {
                right++;
                u.append(w.charAt(i));
            }
            else {
                left++;
                u.append((w.charAt(i)));
            }

            if(right > left)
                ok = false;

            if(right == left) {
                v.append(w.substring(i+1));
                // u가 올바른 괄호 문자열인 경우
                if(ok) {
                    u.append(recusive(v));
                    break;
                }
                // u가 올바른 괄호 문자열이 아닌 경우
                else {
                    StringBuilder sb = new StringBuilder("(");
                    sb.append(recusive(v));
                    sb.append(")");
                    u.deleteCharAt(0);
                    u.deleteCharAt(u.length()-1);
                    for(int j = 0; j < u.length(); j++) {
                        if(u.charAt(j) == ')')
                            u.setCharAt(j, '(');
                        else
                            u.setCharAt(j, ')');
                    }
                    sb.append(u);
                    u = new StringBuilder(sb);
                    break;
                }
            }
        }
        return u.toString();
    }
    public static String solution(String p) {
        String answer = "";

        // 문자열 정의
        StringBuilder w = new StringBuilder(p);
        answer = recusive(w);
        System.out.println(answer);

        return answer;
    }
}
