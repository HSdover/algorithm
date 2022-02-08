package com.algorithm.programmers.lv1;

public class 핸드폰_번호_가리기 {
    public static void main(String[] args) {
        solution("01033334444");
    }

    public static String solution(String phone_number) {
        String answer = "";

        for(int i = 0; i < phone_number.length()-4; i++)
            answer += "*";

        answer += phone_number.substring(phone_number.length()-4);

        return answer;
    }
}
