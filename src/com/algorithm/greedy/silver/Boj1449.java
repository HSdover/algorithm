package com.algorithm.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj1449 {
    //문제
    //항승이는 품질이 심각하게 나쁜 수도 파이프 회사의 수리공이다. 항승이는 세준 지하철 공사에서 물이 샌다는 소식을 듣고 수리를 하러 갔다.
    //
    //파이프에서 물이 새는 곳은 신기하게도 가장 왼쪽에서 정수만큼 떨어진 거리만 물이 샌다.
    //
    //항승이는 길이가 L인 테이프를 무한개 가지고 있다.
    //
    //항승이는 테이프를 이용해서 물을 막으려고 한다. 항승이는 항상 물을 막을 때, 적어도 그 위치의 좌우 0.5만큼 간격을 줘야 물이 다시는 안 샌다고 생각한다.
    //
    //물이 새는 곳의 위치와, 항승이가 가지고 있는 테이프의 길이 L이 주어졌을 때, 항승이가 필요한 테이프의 최소 개수를 구하는 프로그램을 작성하시오. 테이프를 자를 수 없고, 테이프를 겹쳐서 붙이는 것도 가능하다.
    //
    //입력
    //첫째 줄에 물이 새는 곳의 개수 N과 테이프의 길이 L이 주어진다. 둘째 줄에는 물이 새는 곳의 위치가 주어진다. N과 L은 1,000보다 작거나 같은 자연수이고, 물이 새는 곳의 위치는 1,000보다 작거나 같은 자연수이다.
    //
    //출력
    //첫째 줄에 항승이가 필요한 테이프의 개수를 출력한다.

    /**
     * 아이디어
     * 가장 첫번째 나오는 수리지점에서 테이프길이 - 1만큼보다 안쪽에 있는경우는 카운트하지 않고 바깥쪽에 있는 수리지점일경우 기준점을 교체해주고 다시 비교한다.
     * 수리위치 정렬을 해줘야함!!
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] hole = new int[N];
        for(int i = 0; i < N; i++)
            hole[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(hole);

        int p = hole[0];
        int cnt = 1;
        for(int i = 1; i < N; i++) {
            System.out.println(p);
            if(hole[i] > p + L - 1) {
                p = hole[i];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
