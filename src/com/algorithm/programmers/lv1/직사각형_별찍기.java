package com.algorithm.programmers.lv1;

import java.util.Arrays;
import java.util.Scanner;

public class 직사각형_별찍기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder[] sba = new StringBuilder[b];
        for(int i = 0; i < sba.length; i++)
            sba[i] = new StringBuilder("");

        for(int i = 0; i < b; i++) {
            for(int j = 0; j < a; j++)
                sba[i].append("*");
        }

        for(int i = 0; i < sba.length; i++)
            System.out.println(sba[i]);
    }


}
