package com.algorithm.programmers.lv2;

import java.util.*;

public class 위장 {
    public static void main(String[] args) {
        위장 t = new 위장();
        String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
        t.solution(clothes);
    }

    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String[] clothe : clothes) {
            String type = clothe[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        Iterator<Integer> it = map.values().iterator();
        int answer = 1;

        while(it.hasNext())
            answer *= it.next().intValue() + 1;

        System.out.println(answer);
        System.out.println(map);
        return answer - 1;
    }





    // dfs 시간 초과
//    Set<Set<String>> set = new HashSet<>();
//    boolean[] wear;
//    private void dfs(String[][] clothes, Set<String> clothe, Set<String> part) {
//        int cnt = 0;
//        for(int i = 0; i < wear.length; i++) {
//            if(!wear[i])
//                break;
//
//            if(cnt == wear.length-1)
//                return;
//
//            cnt++;
//        }
//        for(int i = 0; i < clothes.length; i++) {
//            if(!wear[i]) {
//                Set<String> newClothe = new HashSet<>(clothe);
//                Set<String> newPart = new HashSet<>(part);
//                if(!newPart.contains(clothes[i][1])) {
//                    newPart.add(clothes[i][1]);
//                    newClothe.add(clothes[i][0]);
//                    set.add(newClothe);
//                }
//                wear[i] = true;
//                dfs(clothes, newClothe, newPart);
//                wear[i] = false;
//            }
//        }
//    }


//    for(int i = 0; i < clothes.length; i++) {
//        Set<String> clothe = new HashSet<>();
//        Set<String> part = new HashSet<>();
//        part.add(clothes[i][1]);
//        clothe.add(clothes[i][0]);
//        set.add(clothe);
//
//        for(int j = 0; j < clothes.length; j++) {
//            if(!part.contains(clothes[j][1])) {
//                Set<String> newClothe = new HashSet<>(clothe);
//                newClothe.add(clothes[j][0]);
//                set.add(newClothe);
//            }
//        }
//    }
}
