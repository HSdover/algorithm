package com.algorithm.greedy;

public class prac {
    public static void main(String[] args) {

        String s = "ababababa";
        System.out.println(s.substring(0, s.indexOf("aba")) + s.substring(s.indexOf("aba") + 3, s.length()));
    }


}
