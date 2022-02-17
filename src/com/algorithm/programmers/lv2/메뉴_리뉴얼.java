package com.algorithm.programmers.lv2;

import java.util.*;

public class 메뉴_리뉴얼 {
    public static void main(String[] args) {
        solution();
    }

    private static Map<String, Integer> count = new HashMap<>();
    private static void dfs(String s, String menu, boolean[] check, int cnt, int idx) {
        if(menu.length() == cnt) {
            char[] c = menu.toCharArray();
            Arrays.sort(c);
            menu = new String(c);
            if(!count.containsKey(menu))
                count.put(menu, 1);
            else
                count.put(menu, count.get(menu) + 1);
            return;
        }
        for(int i = idx; i < s.length(); i++) {
            String nMenu = menu;
            if(check[i])
                continue;
            else {
                check[i] = true;
                nMenu += s.charAt(i);
            }
            dfs(s, nMenu, check, cnt, i);
            check[i] = false;
        }
    }

    public static List<String> solution() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        List<String> answer = new ArrayList<>();

        for(int i = 0; i < orders.length; i++) {
            for(int j = 0; j < course.length; j++) {
                boolean[] check = new boolean[orders[i].length()];
                int idx = 0;
                String menu = "";
                dfs(orders[i], menu, check, course[j], idx);
            }
        }

        for(int i = 0; i < course.length; i++) {
            int max = 0;
            for(String key : count.keySet()) {
                if(key.length() == course[i]) {
                    if(count.get(key) > max)
                        max = count.get(key);
                }
            }
            for(String key : count.keySet()) {
                if(key.length() == course[i]) {
                    if(count.get(key) == max && max != 1)
                        answer.add(key);
                }
            }
        }
        answer.sort(Comparator.naturalOrder());

        System.out.println(answer);
        return answer;
    }


}
