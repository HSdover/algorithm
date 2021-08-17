package com.algorithm.greedy;

public class prac {
    public static void main(String[] args) {

        String reg = "^[,][0-9]*$";
        String m = ",999,999";

        System.out.println(m.substring(4, m.length() - 1).matches(reg));
    }


}
