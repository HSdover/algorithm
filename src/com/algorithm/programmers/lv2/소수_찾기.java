package com.algorithm.programmers.lv2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
"013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
*/
public class 소수_찾기 {
    public static void main(String[] args) {
        solution("011");
    }

    private static Set<Integer> prime = new HashSet<>();
    private static void dfs(String[] num, boolean[] check, String s) {
        int cnt = 0;
        for(int i = 0; i < check.length; i++) {
            if(!check[i])
                break;
            else {
                if(cnt == check.length-1)
                    return;
                cnt++;
            }
        }

        for(int i = 0; i < num.length; i++) {
            String ss = s;
            if(!check[i]) {
                ss += num[i];
                check[i] = true;
                while(ss.length() != 0 && ss.charAt(0) == '0')
                    ss = ss.substring(1);
                if(ss.length() != 0)
                    prime.add(Integer.parseInt(ss));
                dfs(num, check, ss);
                check[i] = false;
            }
        }
    }

    public static int solution(String numbers) {
        int answer = 0;

        String[] num = new String[numbers.length()];
        for(int i = 0; i < numbers.length(); i++)
            num[i] = numbers.substring(i, i+1);

        boolean[] check = new boolean[numbers.length()];
        String s = new String();
        dfs(num, check, s);

        answer = prime.size();
        for(int i : prime) {
            int divide = 2;
            if(i == 1) {
                answer--;
                continue;
            }
            while(divide <= Math.sqrt(i)) {
                if((i % divide) == 0) {
                    System.out.println(i);
                    answer--;
                    break;
                }
                divide++;
            }
        }

        System.out.println(prime);
        System.out.println(answer);
        return answer;
    }
}
