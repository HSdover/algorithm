package com.algorithm.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Boj1339 {
    // 문제
    //민식이는 수학학원에서 단어 수학 문제를 푸는 숙제를 받았다.
    //
    //단어 수학 문제는 N개의 단어로 이루어져 있으며, 각 단어는 알파벳 대문자로만 이루어져 있다. 이때, 각 알파벳 대문자를 0부터 9까지의 숫자 중 하나로 바꿔서 N개의 수를 합하는 문제이다. 같은 알파벳은 같은 숫자로 바꿔야 하며, 두 개 이상의 알파벳이 같은 숫자로 바뀌어지면 안 된다.
    //
    //예를 들어, GCF + ACDEB를 계산한다고 할 때, A = 9, B = 4, C = 8, D = 6, E = 5, F = 3, G = 7로 결정한다면, 두 수의 합은 99437이 되어서 최대가 될 것이다.
    //
    //N개의 단어가 주어졌을 때, 그 수의 합을 최대로 만드는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 단어의 개수 N(1 ≤ N ≤ 10)이 주어진다. 둘째 줄부터 N개의 줄에 단어가 한 줄에 하나씩 주어진다. 단어는 알파벳 대문자로만 이루어져있다. 모든 단어에 포함되어 있는 알파벳은 최대 10개이고, 수의 최대 길이는 8이다. 서로 다른 문자는 서로 다른 숫자를 나타낸다.
    //
    //출력
    //첫째 줄에 주어진 단어의 합의 최댓값을 출력한다.

    /**
     * 아이디어
     * 문자열의 길이가 가장 큰 수를 결정하므로 길이의 내림차순으로 정렬한다.
     * 아스키 코드(대문자 A는 65부터 시작)를 이용 알파벳 별로 자릿수의 값(ex/ 10의 자리 +10, 100의 자리 +10^2, 1000의 자리 +10^3)
     * 내림차순으로 정렬하여 9부터 차레대로 곱하고 더해준다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] S = new String[N];
        // 알파벳의 개수는 26개 이므로 26개 선언
        Integer[] alpha = new Integer[26];

        for(int i = 0; i < 26; i++)
            alpha[i] = 0;

        for(int i = 0; i < N; i++)
            S[i] = br.readLine();

        for(int i = 0; i < S.length; i++) {
            int leng = S[i].length() - 1;
            // 알파벳에 따라 자리수를 더해준다.
            for(int j = 0; j < S[i].length(); j++) {
                alpha[(int) S[i].charAt(j) - 65] += (int) Math.pow(10, leng);
                leng--;
            }
        }
        // 자리수가 큰 수대로 정렬
        Arrays.sort(alpha, Collections.reverseOrder());

        int sum = 0;
        int cnt = 9;
        for(int i = 0; i < 26; i++){
            // alpha 배열은 0으로 초기화돼있고 내림차순정렬하였기 때문에 0을 만나면 반복문을 탈출한다.
            if(alpha[i] == 0)
                break;
            sum += alpha[i] * cnt;
            cnt--;
        }
        System.out.println(sum);
    }
}
