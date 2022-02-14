package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 단체사진_찍기 {
    public static void main(String[] args) {
        solution();
    }

    // List를 사용할때 주의할 것
    // List를 사용하여 복사할때 주소값으로 복사되기 때문에 같은값으로 처리돼 내가 원하는 연산 불가능
    static int answer = 0;
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static int solution() {
        int n = 2;
        String[] data = {"N~F=0", "R~T>2"};

        boolean[] isVisited = new boolean[8];
        dfs("", isVisited, data);
        System.out.println(answer);
        return answer;
    }

    private static void dfs(String names, boolean[] isVisited, String[] datas) {
        if(names.length() == 7) {
            if(check(names, datas)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) { // 조합
            if (!isVisited[i]) {
                isVisited[i] = true;
                String name = names + friends[i];
                dfs(name, isVisited, datas);
                isVisited[i] = false;
            }
        }
    }

    private static boolean check(String names, String[] datas) {
        for(String s : datas) {
            int pos1 = names.indexOf(s.charAt(0));
            int pos2 = names.indexOf(s.charAt(2));
            char op = s.charAt(3);
            int inter = s.charAt(4) - '0';
            if(op == '=') {
                if(!(Math.abs(pos1 - pos2) == inter+1))
                    return false;
            } else if(op == '>') {
                if(!(Math.abs(pos1 - pos2) > inter+1))
                    return false;
            } else if(op == '<') {
                if(!(Math.abs(pos1 - pos2) < inter+1))
                    return false;
            }
        }
        return true;
    }
}
