package com.algorithm.greedy;

public class prac {
    public static void main(String[] args) {

        String s = "abcdecdabcda";
        System.out.println(s.indexOf("cda"));
        System.out.println(s.substring(s.indexOf("cda") + 3));
    }


}
