package com.algorithm.programmers.lv2;

import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.Arrays;
import java.util.Comparator;

public class 전화번호_목록 {
    public static void main(String[] args) {
        solution();
    }

    public static boolean solution() {
        String[] phone_book = {"123", "125", "123523", "123982"};
        boolean answer = true;

        // String정렬이므로 바로 다음 녀석이 안맞으면 바로 넘겨도 된다..
        Arrays.sort(phone_book);
        for(int i = 0; i < phone_book.length-1; i++) {
            for(int j = i; j < i+2; j++) {
                if(i != j) {
                    if(phone_book[j].startsWith(phone_book[i])) {
                        answer = false;
                        break;
                    }
                }
            }
            if(!answer)
                break;
        }
        return answer;
    }
}
