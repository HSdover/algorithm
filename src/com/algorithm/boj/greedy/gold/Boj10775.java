package com.algorithm.boj.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj10775 {
    //문제
    //오늘은 신승원의 생일이다.
    //
    //박승원은 생일을 맞아 신승원에게 인천국제공항을 선물로 줬다.
    //
    //공항에는 G개의 게이트가 있으며 각각은 1에서 G까지의 번호를 가지고 있다.
    //
    //공항에는 P개의 비행기가 순서대로 도착할 예정이며, 당신은 i번째 비행기를 1번부터 gi (1 ≤ gi ≤ G) 번째 게이트중 하나에 영구적으로 도킹하려 한다. 비행기가 어느 게이트에도 도킹할 수 없다면 공항이 폐쇄되고, 이후 어떤 비행기도 도착할 수 없다.
    //
    //신승원은 가장 많은 비행기를 공항에 도킹시켜서 박승원을 행복하게 하고 싶어한다. 승원이는 비행기를 최대 몇 대 도킹시킬 수 있는가?
    //
    //입력
    //첫 번째 줄에는 게이트의 수 G (1 ≤ G ≤ 105)가 주어진다.
    //
    //두 번째 줄에는 비행기의 수 P (1 ≤ P ≤ 105)가 주어진다.
    //
    //이후 P개의 줄에 gi (1 ≤ gi ≤ G) 가 주어진다.
    //
    //출력
    //승원이가 도킹시킬 수 있는 최대의 비행기 수를 출력한다.

    /**
     * 아이디어
     * 같은 게이트에 여러 비행기가 들어올 경우 더 낮은 게이트번호를 가진 게이트에 도킹한다. 게이트가 가득 차서 도킹이 불가능할 경우 공항을 폐쇄한다.
     * - 유니온 파인드 알고리즘을 이용한다.
     */
    static int G, P;
    static int[] pg;

    public static int get(int a) {
        if(pg[a] == a)
            return a;
        return pg[a] = get(pg[a]);
    }

    public static void union(int a, int b) {
        if(pg[a] < pg[b])
            pg[b] = pg[a];
        else
            pg[a] = pg[b];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());
        P = Integer.parseInt(br.readLine());
        pg = new int[G + 1];
        for(int i = 0; i < G + 1; i++)
            pg[i] = i;

        int[] g = new int[P];
        for(int i = 0; i < P; i++)
            g[i] = Integer.parseInt(br.readLine());

        int ans = 0;
        for(int i = 0; i < P; i++) {
            if(get(g[i]) != 0) {
                union(get(g[i]), get(g[i])-1);
                ans++;
            }
            else
                break;
        }
        System.out.println(ans);
    }
}
