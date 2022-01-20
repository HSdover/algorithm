package com.algorithm.programmers.lv1;

import java.util.Locale;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        solution();
    }
    public static String solution() {
        String new_id = "neW_id@%$#";
        String answer = "";

        String new_new_id = new_id;
        new_new_id = new_id.toLowerCase(Locale.ROOT).replaceAll("[^a-z._-]", "");
        System.out.println(new_new_id);
        return answer;
    }

}
