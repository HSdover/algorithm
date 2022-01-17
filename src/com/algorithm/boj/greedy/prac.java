package com.algorithm.boj.greedy;

import java.util.*;

public class prac {
    public static void main(String[] args) {

        List<String> id = Arrays.asList("a,b", "b,c", "a,b", "c,d");

        Set<String> set = new HashSet<String>(id);

        List<String> newid = new ArrayList<String>(set);

        System.out.println(newid);
    }


}
