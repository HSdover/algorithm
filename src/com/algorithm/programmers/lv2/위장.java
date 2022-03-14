package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 위장 {
    public static void main(String[] args) {
        위장 t = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        t.solution(clothes);
    }

    int cnt = 0;
    boolean[] wear;

    public int solution(String[][] clothes) {
        int answer = 0;

        Set<String> set = new HashSet<>();
        wear = new boolean[clothes.length];

        dfs(clothes, set);
        System.out.println(cnt);
        return answer;
    }

    private void dfs(String[][] clothes, Set<String> set) {

        for(int i = 0; i < clothes.length; i++) {
            Set<String> newSet = new HashSet<>(set);

            if(newSet.contains(clothes[i][1]) && wear[i])
                continue;
            else {
                newSet.add(clothes[i][1]);
                System.out.println(newSet);
                cnt++;
                wear[i] = true;
                dfs(clothes, newSet);
                wear[i] = false;
            }
        }
    }
}
