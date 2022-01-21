package com.algorithm.programmers.lv1;

import java.util.Locale;

public class 신규_아이디_추천 {
    public static void main(String[] args) {
        solution();
    }

    public static String solution() {
        String new_id = "aaaaaaaaaaaaaaaa";

        //1,2단계
        new_id = new_id.toLowerCase(Locale.ROOT).replaceAll("[^0-9a-z._-]", "");
        System.out.println("1,2단계 : " + new_id);

        // 문자 변경을 쉽고 효율적으로 하기위해 빌더로 변환
        StringBuilder sb_new_id = new StringBuilder(new_id);
        //3단계
        int dotCnt = 0;
        for (int i = 0; i < sb_new_id.length(); i++) {
            if (sb_new_id.charAt(i) == '.')
                dotCnt++;
            else
                dotCnt = 0;

            if (dotCnt == 2) {
                sb_new_id.deleteCharAt(i);
                dotCnt--;
                // 문자열에서 한 글자 삭제 시 반목문 인덱스도 뒤로 한칸 돌려준다.
                i--;
            }
        }
        System.out.println("3단계 : " + sb_new_id);

        //4단계
        if (!(sb_new_id.length() == 0)) {
            if (sb_new_id.charAt(0) == '.')
                sb_new_id.deleteCharAt(0);
        }
        if (!(sb_new_id.length() == 0)) {
            if (sb_new_id.charAt(sb_new_id.length() - 1) == '.')
                sb_new_id.deleteCharAt(sb_new_id.length() - 1);
        }
        System.out.println("4단계 : " + sb_new_id);

        //5단계
        if (sb_new_id.length() == 0)
            sb_new_id = new StringBuilder("a");
        System.out.println("5단계 : " + sb_new_id);


        //6단계
        if (sb_new_id.length() > 15)
            sb_new_id = new StringBuilder(sb_new_id.substring(0, 15));
        if (sb_new_id.charAt(sb_new_id.length() - 1) == '.')
            sb_new_id.deleteCharAt(sb_new_id.length() - 1);
        System.out.println("6단계 : " + sb_new_id);

        //7단계
        if (sb_new_id.length() == 1) {
            String cha = sb_new_id.toString();
            sb_new_id.append(cha);
            sb_new_id.append(cha);
        }
        if (sb_new_id.length() == 2) {
            char cha = sb_new_id.toString().charAt(1);
            sb_new_id.append(cha);
        }

        String answer = sb_new_id.toString();
        return answer;
    }

}
