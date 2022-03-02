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

        Arrays.sort(phone_book, Com);
        for(int i = 0; i < phone_book.length; i++) {
            for(int j = 0; j < phone_book.length; j++) {
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
