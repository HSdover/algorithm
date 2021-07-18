package com.algorithm.greedy;

import java.io.*;
import java.util.Arrays;

public class Boj10610 {
    //문제
    //어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
    //
    //미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.
    //
    //입력
    //N을 입력받는다. N는 최대 10^5개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
    //
    //출력
    //미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.

    // 10^5 = 100000까지가 아니라 숫자 개수가 10만개였음 문제를 잘 이해하자!
    // 10만개를 숫자로 표현할 수 있는 자료형은 없다. 문자열로 받아서 하자..
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        // 답은 맞췄지만 다른 사람이 푼걸보니 List가 아닌 Array를 이용하면 처리속도를 더 빠르게 할 수 있음
        char[] arrayN = N.toCharArray();

        int sum = 0;
        for(int i : arrayN){
            sum += i;
        }

        if(!(N.contains("0")) || !(sum % 3 == 0))
            N = "-1";
        else {
            Arrays.sort(arrayN);
            N = new StringBuilder(new String(arrayN)).reverse().toString();
        }

        System.out.println(N);
        //출력도 bufferWrite를 이용하면 속도를 올릴 수 있다.

        // 내 답
//        ArrayList<String> num = new ArrayList<>();
//
//        int sum = 0;
//        for(int i = 0; i < N.length(); i++) {
//            num.add(N.substring(i, i+1));
//            sum += Integer.parseInt(N.substring(i, i+1));
//        }
//
//        Collections.sort(num, Collections.reverseOrder());
//
//        //다시 합치는 과정 https://javacan.tistory.com/entry/41 여기선 쓰이진 않지만 저것도 생각해보자
//        N = String.join("", num);
//
//        if(!(N.substring(N.length()-1, N.length()).equals("0")))
//            N = "-1";
//        else if(!(sum % 3 == 0))
//            N = "-1";
//
//        System.out.println(N);


        //int로 풀었음..
//        // 기본 값
//        int N = Integer.parseInt(br.readLine());
//
//
//        //N의 값을 자를경우 길이를 모르기 때문에 탐색, 정렬을 위해 ArrayList에 담는다.(LinkedList와 비교!)
//        ArrayList<Integer> num = new ArrayList<>();
//
//        //N의 숫자를 하나씩 num에 담자
//        while (N > 0) {
//            num.add(N % 10);
//            N /= 10;
//        }
//
//        System.out.println(num);
//        // 기본 값에서 가장 큰 숫자의 순서대로 정렬. 정렬법 비교.
//        Collections.sort(num);
//        System.out.println(num);
//
//        N = num.get(0);
//        //가장 큰 수 순서대로 정렬
//        for (int i = 1; i < num.size(); i++)
//            N += num.get(i) * Math.pow(10, i);
//
//        int sum = 0;
//
//        for (int i = 0; i < num.size(); i++) {
//            sum += num.get(i);
//        }
//        System.out.println(sum);
//
//        // 조건1. N이 30의 배수가 되기 위해선 10의 배수 판정법에 의해 끝자리 수가 무조건 0이어야함.
//        if (!(N % 10 == 0))
//            N = -1;
//        // 조건2. N이 30의 배수가 되기 위해선 3의 배수 판정법을 통과해야함.
//        else if(!(sum % 3 == 0))
//            N = -1;
//
//        System.out.println(N);
    }
}
