package com.algorithm.programmers.lv2;

public class 짝지어_제거하기 {
    public static void main(String[] args) {
        solution("baabaa");
    }

    public static int solution(String s) {
        int answer = -1;

        String front = "";
        while(true) {
            String sOne = s.substring(0, 1);
            s = s.substring(1);
            if(sOne == s.substring(0, 1))
                s = front + s.substring(1);
            else
                front += sOne;
        }


        return answer;
    }
}
