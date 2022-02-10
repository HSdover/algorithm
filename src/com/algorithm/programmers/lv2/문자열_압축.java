package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 문자열_압축 {
    public static void main(String[] args) {
        solution("a");
    }

    public static int solution(String s) {
        int answer = 0;

        // 단계별로 나누어진 문자열 배열 만들기
        List<String[]> sSubstring = new ArrayList<>();
        String[] sArr;
        StringBuilder sCopy;
        //s.length가 2보다 작은경우 반복문에 못들어가서 연산이 불가능함..
        if(s.length() == 1) {
            sArr = new String[1];
            sArr[0] = s;
            sSubstring.add(sArr);
        }
        for(int i = 1; i <= s.length()/2; i++) {
            if(s.length() % i != 0)
                sArr = new String[s.length()/i+1];
            else
                sArr = new String[s.length()/i];
            sCopy = new StringBuilder(s);
            for(int j = 0; j < sArr.length; j++) {
                if(sCopy.length() >= i) {
                    sArr[j] = sCopy.substring(0, i);
                    sCopy = new StringBuilder(sCopy.substring(i));
                }
            }
            if(s.length() % i != 0)
                sArr[sArr.length-1] = sCopy.toString();
            sSubstring.add(sArr);
        }

        // 문자열 압축하기
        int cnt = 1;
        String letter;
        List<String> sbList = new ArrayList<>();
        StringBuilder sComp;
        for(int i = 0; i < sSubstring.size(); i++) {
            sArr = sSubstring.get(i);
            letter = sArr[0];
            sComp = new StringBuilder();
            for(int j = 1; j < sSubstring.get(i).length; j++) {
                if(letter.equals(sArr[j]))
                    cnt++;
                else {
                    if(cnt != 1) {
                        sComp.append(cnt);
                        cnt = 1;
                    }
                    sComp.append(letter);
                    letter = sArr[j];
                }
            }
            if(cnt != 1) {
                sComp.append(cnt);
                cnt = 1;
            }
            sComp.append(letter);
            sbList.add(sComp.toString());
        }

        System.out.println(sbList);
        // 가장 작은 문자열 구하기
        int minLeng = sbList.get(0).length();
        for(int i = 1; i < sbList.size(); i++) {
            if(sbList.get(i).length() < minLeng)
                minLeng = sbList.get(i).length();
        }
        System.out.println(minLeng);
        return answer;
    }
}
