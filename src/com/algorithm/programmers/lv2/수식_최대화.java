package com.algorithm.programmers.lv2;

import java.util.*;

public class 수식_최대화 {
    public static void main(String[] args) {
        solution("999*999*999*999*999");
    }

    public static long solution(String expression) {
        long answer = 0;

        List<String> ex = new ArrayList<>();
        List<String> checkOp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < expression.length(); i++) {
            if(expression.charAt(i) == '*' || expression.charAt(i) == '-' || expression.charAt(i) == '+') {
                if(!checkOp.contains(String.valueOf(expression.charAt(i))))
                    checkOp.add(String.valueOf(expression.charAt(i)));
                ex.add(sb.toString());
                ex.add(String.valueOf(expression.charAt(i)));
                sb = new StringBuilder();
            }
            else
                sb.append(expression.charAt(i));
        }
        ex.add(sb.toString());

        boolean[] ok = new boolean[checkOp.size()];
        dfs(ex,checkOp,ok);

        System.out.println(ans);
        for(int i = 0; i < ans.size(); i++) {
            if(answer < ans.get(i))
                answer = ans.get(i);
        }
        System.out.println(answer);
        return answer;
    }

    private static List<Long> ans = new ArrayList<>();
    private static void dfs(List<String> ex, List<String> checkOp, boolean[] ok) {
        if(ex.size() == 1) {
            ans.add(Math.abs(Long.parseLong((ex.get(0)))));
            return;
        }

        long a = 0, b = 0, sum = 0;
        for(int i = 0; i < checkOp.size(); i++) {
            List<String> ex2 = new ArrayList<>(ex);
            if(!ok[i]) {
                ok[i] = true;
                for(int j = 1; j < ex2.size(); j+=2) {
                    if(ex2.get(j).equals(checkOp.get(i))) {
                        if(ex2.get(j).equals("*")) {
                            a = Long.parseLong(ex2.get(j-1));
                            b = Long.parseLong(ex2.get(j+1));
                            sum = a * b;
                            ex2.set(j-1, String.valueOf(sum));
                            ex2.remove(j);
                            ex2.remove(j);
                            j -= 2;
                        }
                        else if(ex2.get(j).equals("-")) {
                            a = Long.parseLong(ex2.get(j-1));
                            b = Long.parseLong(ex2.get(j+1));
                            sum = a - b;
                            ex2.set(j-1, String.valueOf(sum));
                            ex2.remove(j);
                            ex2.remove(j);
                            j -= 2;
                        }
                        else if(ex2.get(j).equals("+")) {
                            a = Long.parseLong(ex2.get(j-1));
                            b = Long.parseLong(ex2.get(j+1));
                            sum = a + b;
                            ex2.set(j-1, String.valueOf(sum));
                            ex2.remove(j);
                            ex2.remove(j);
                            j -= 2;
                        }
                    }
                }
                dfs(ex2, checkOp, ok);
                ok[i] = false;
            }
        }

    }
}
