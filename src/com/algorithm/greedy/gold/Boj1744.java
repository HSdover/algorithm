package com.algorithm.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

//문제
//길이가 N인 수열이 주어졌을 때, 그 수열의 합을 구하려고 한다. 하지만, 그냥 그 수열의 합을 모두 더해서 구하는 것이 아니라, 수열의 두 수를 묶으려고 한다. 어떤 수를 묶으려고 할 때, 위치에 상관없이 묶을 수 있다. 하지만, 같은 위치에 있는 수(자기 자신)를 묶는 것은 불가능하다. 그리고 어떤 수를 묶게 되면, 수열의 합을 구할 때 묶은 수는 서로 곱한 후에 더한다.
//
//예를 들면, 어떤 수열이 {0, 1, 2, 4, 3, 5}일 때, 그냥 이 수열의 합을 구하면 0+1+2+4+3+5 = 15이다. 하지만, 2와 3을 묶고, 4와 5를 묶게 되면, 0+1+(2*3)+(4*5) = 27이 되어 최대가 된다.
//
//수열의 모든 수는 단 한번만 묶거나, 아니면 묶지 않아야한다.
//
//수열이 주어졌을 때, 수열의 각 수를 적절히 묶었을 때, 그 합이 최대가 되게 하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 수열의 크기 N이 주어진다. N은 10,000보다 작은 자연수이다. 둘째 줄부터 N개의 줄에, 수열의 각 수가 주어진다. 수열의 수는 -10,000보다 크거나 같고, 10,000보다 작거나 같은 정수이다.
//
//출력
//수를 합이 최대가 나오게 묶었을 때 합을 출력한다. 정답은 항상 2^31보다 작다.
public class Boj1744 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[N];
        int sum = 0;

        for(int i = 0; i < N; i++)
            num[i] = Integer.parseInt(br.readLine());

        Arrays.sort(num);

        ArrayList<Integer> m = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        int one = 0;
        //음수와 양수로 나눔(0은 음수에 포함)
        for(int i = 0; i < N; i++){
            if(num[i] <= 0)
                m.add(num[i]);
            else if(num[i] == 1)
                one += 1;
            else
                p.add(num[i]);
        }
        //음수가 짝수개 경우
        if(m.size() % 2 == 0 && m.size() != 0) {
            for(int i = 0; i < m.size(); i+=2)
                sum += m.get(i) * m.get(i + 1);
        }
        //음수가 홀수개 경우
        else if(m.size() % 2 == 1){
            if(m.size() != 1) {
            for(int i = 0; i < m.size() - 1; i+=2)
                sum += m.get(i) * m.get(i + 1);
            }
            sum += m.get(m.size() - 1);
        }

        //양수가 짝수개 경우
        if(p.size() % 2 == 0 && p.size() != 0) {
            for(int i = 0; i < p.size(); i+=2)
                sum += p.get(i) * p.get(i + 1);
        }
        //양수가 홀수개 경우
        else if(p.size() % 2 == 1){
            if(p.size() != 1) {
                for(int i = 1; i < p.size(); i+=2)
                    sum += p.get(i) * p.get(i + 1);
            }
            sum += p.get(0);
        }
        sum += one;

        System.out.println(sum);

//        int i = 0;
//        while(true) {
//            if(i > N - 1)
//                break;
//
//            if(num[i] <= 0)
//                m.add(num[i]);
//            else
//                p.add(num[i]);
//            i++;
//        }
//
//        i = 0;
//        while(true) {
//            if(i > m.size())
//                break;
//            else if(m.size() == 1)
//                sum += m.get(0);
//            else if(m.size() % 2 == 0) {
//                sum += m.get(i) * m.get(i + 1);
//            }
//            else if(i == m.size() - 1)
//                sum += m.get(i);
//            else
//                sum += m.get(i) * m.get(i + 1);
//            i += 2;
//        }
//
//        i = p.size();
//        while(true) {
//            if(i < 0)
//                break;
//            else if(p.size() == 1)
//                sum += p.get(0);
//            else if(p.size() % 2 == 0)
//                sum += p.get(i - 1) * p.get(i - 2);
//            else if(i == 1)
//                sum += p.get(0);
//            else
//                sum += p.get(i - 1) * p.get(i - 2);
//
//            i -= 2;
//        }
//        System.out.println(sum);
    }
}
