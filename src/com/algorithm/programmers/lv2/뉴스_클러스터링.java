package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 뉴스_클러스터링 {
    public static void main(String[] args) {
        solution("aa1+aa2", "AAAA12");
    }

    public static int solution(String str1, String str2) {
        int answer = 0;

        if(str1.toLowerCase().equals(str2.toLowerCase()))
            return 65536;
        //유사도 검사 집합으로 바꾸기
        List<String> arr1 = new ArrayList<>();
        List<String> arr2 = new ArrayList<>();
        for(int i = 0; i < str1.length()-1; i++) {
            String s = str1.substring(i, i+2).toLowerCase();
            if(s.matches("^[a-z]{2}"))
                arr1.add(s);
        }
        for(int i = 0; i < str2.length()-1; i++) {
            String s = str2.substring(i, i+2).toLowerCase();
            if(s.matches("^[a-z]{2}"))
                arr2.add(s);
        }

        // 교집합 만들기
        List<String> inter = new ArrayList<>();
        for(int i = 0; i < arr1.size(); i++) {
            System.out.println(i);
            for(int j = 0; j < arr2.size(); j++) {
               if(arr1.get(i).equals(arr2.get(j))) {
                   inter.add(arr1.get(i));
                   arr1.remove(i);
                   arr2.remove(j);
                   i--;
                   break;
               }
            }
        }
        // 합집합 만들기
        List<String> union = new ArrayList<>(inter);
        for(int i = 0; i < arr1.size(); i++)
            union.add(arr1.get(i));
        for(int i = 0; i < arr2.size(); i++)
            union.add(arr2.get(i));

        double d = ((double)inter.size() / (double)union.size()) * 65536;

        answer = (int)d;

        return answer;
    }
}
