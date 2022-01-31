package com.algorithm.boj.greedy.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

//문제
//영관이는 게임을 좋아한다. 별의별 게임을 다 하지만 그 중에서 제일 좋아하는 게임은 모두의 마블이다. 어김없이 오늘도 영관이는 학교 가는 버스에서 캐릭터 합성 이벤트를 참여했다.
//
//이번 이벤트는 다음과 같다. 순서가 매겨진 여러 장의 카드가 있다. 각각의 카드는 저마다 레벨이 있다.
//
//카드 A에 카드 B를 덧붙일 수 있다. 이때 붙이는 조건은 다음과 같다.
//
//두 카드는 인접한 카드여야 한다.
//업그레이드 된 카드 A의 레벨은 변하지 않는다.
//카드 합성을 할 때마다 두 카드 레벨의 합만큼 골드를 받는다.
//
//영관이가 골드를 최대한 많이 받을 수 있게 여러분이 도와주자.
//
//예를 들어, c1, c2, c3로 연속된 카드 3개가 있고 각각 레벨이 40,30,30 이라고 하자.
//
//이 카드들을 합치는 과정에서, 먼저 c3에 c2를 합쳐 임시 카드 x1을 만든다. x1의 레벨은 30이고 획득 골드는 60이다. 그 다음엔 c1에 x1을 합쳐 카드 x2를 만들면 레벨이 40이고 70만큼의 골드를 획득할 수 있다. 이때, 영관이가 획득한 골드는 70+60 = 130이다.
//
//다른 방법으로 c1에 c2를 덧붙인 카드 x1을 만들면, x1의 레벨은 40이고 획득한 골드는 70이다.
//
//x1에 c3를 덧붙인 카드 x2의 레벨은 40이고 획득 골드는 70이다. 이때, 영관이가 획득한 골드는 70 + 70 = 140이다. 이외에 더 많은 골드를 받는 방법이 없으므로 140이 획득할 수 있는 최대 골드이다.
//
//입력
//카드의 개수 n(0 < n ≤ 1,000)이 주어진다.
//
//다음 줄에 각각 카드의 레벨 Li가 순서대로 주어진다. (0 < Li ≤ 100,000)
//
//출력
//영관이가 받을 수 있는 골드의 최댓값을 출력한다.
public class Boj12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] card = new Integer[n];
        int money = 0;
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < card.length; i++)
            card[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(card, Collections.reverseOrder());

        int max = card[0];
        for(int i = 1; i < card.length; i++) {
            money += max + card[i];
        }

        System.out.println(money);
    }
}