package com.algorithm.programmers.lv2;

import java.util.*;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        solution("aasdskiekdllpwos");
    }

    public static int solution(String s) {
        int answer = 0;

        char[] cArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < cArr.length; i++) {
            if(!stack.isEmpty()) {
                if(stack.peek() == cArr[i])
                    stack.pop();
                else
                    stack.add(cArr[i]);
            }
            else
                stack.add(cArr[i]);
        }
        if(stack.isEmpty())
            answer = 1;


        return answer;
    }
}
