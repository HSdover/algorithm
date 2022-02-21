package com.algorithm.programmers.lv2;

import java.util.*;

public class 수식_최대화 {
    public static void main(String[] args) {
        solution("100-200*300-500+20");
    }

    private static List<Long> ans = new ArrayList<>();
    private static void dfs(List<Long> num, List<String> op, List<String> checkOp, boolean[] ok) {
        for(int i = 0; i < checkOp.size(); i++) {
            ok[i] = true;
            for(int j = 0; j < op.size(); j++) {
                if(op.get(j).equals(checkOp.get(i))) {

                }
            }

        }
    }

    public static long solution(String expression) {
        long answer = 0;

        List<Long> num = new ArrayList<>();
        List<String> op = new ArrayList<>();
        Set<String> checkOp = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '*' || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                checkOp.add(String.valueOf(expression.charAt(i)));
                op.add(String.valueOf(expression.charAt(i)));
                num.add(Long.parseLong(sb.toString()));
                sb = new StringBuilder();
            }
            else
                sb.append(expression.charAt(i));
        }
        num.add(Long.parseLong(sb.toString()));

        boolean[] ok = new boolean[checkOp.size()];
        dfs(num, op, checkOp, ok);


        return answer;
    }
}
