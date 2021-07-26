package com.algorithm.greedy.one;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//문제
//한 개의 회의실이 있는데 이를 사용하고자 하는 N개의 회의에 대하여 회의실 사용표를 만들려고 한다. 각 회의 I에 대해 시작시간과 끝나는 시간이 주어져 있고, 각 회의가 겹치지 않게 하면서 회의실을 사용할 수 있는 회의의 최대 개수를 찾아보자. 단, 회의는 한번 시작하면 중간에 중단될 수 없으며 한 회의가 끝나는 것과 동시에 다음 회의가 시작될 수 있다. 회의의 시작시간과 끝나는 시간이 같을 수도 있다. 이 경우에는 시작하자마자 끝나는 것으로 생각하면 된다.
//
//입력
//첫째 줄에 회의의 수 N(1 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N+1 줄까지 각 회의의 정보가 주어지는데 이것은 공백을 사이에 두고 회의의 시작시간과 끝나는 시간이 주어진다. 시작 시간과 끝나는 시간은 2^31-1보다 작거나 같은 자연수 또는 0이다.
//
//출력
//첫째 줄에 최대 사용할 수 있는 회의의 최대 개수를 출력한다.
public class Boj1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        //2^31 - 1은 int 가능.
        //이번엔 2차원 배열을 이용해보자.
        int [][] session = new int[N][3];
        int cnt = 1;
        int cp = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            session[i][0] = Integer.parseInt(st.nextToken());
            session[i][1] = Integer.parseInt(st.nextToken());
        }
        //끝나는 시간을 기준으로 정렬하고 같을 경우 시작 시간순으로 정렬
        Arrays.sort(session, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        cp = session[0][1];

        for(int i = 1; i < N; i++) {
            if(cp <= session[i][0]) {
                cnt++;
                cp = session[i][1];
            }
        }

        System.out.println(cnt);
    }
}
