package com.algorithm.programmers.lv2;
/*
조이스틱으로 알파벳 이름을 완성하세요. 맨 처음엔 A로만 이루어져 있습니다.
ex) 완성해야 하는 이름이 세 글자면 AAA, 네 글자면 AAAA

조이스틱을 각 방향으로 움직이면 아래와 같습니다.

▲ - 다음 알파벳
▼ - 이전 알파벳 (A에서 아래쪽으로 이동하면 Z로)
◀ - 커서를 왼쪽으로 이동 (첫 번째 위치에서 왼쪽으로 이동하면 마지막 문자에 커서)
▶ - 커서를 오른쪽으로 이동 (마지막 위치에서 오른쪽으로 이동하면 첫 번째 문자에 커서)
예를 들어 아래의 방법으로 "JAZ"를 만들 수 있습니다.

- 첫 번째 위치에서 조이스틱을 위로 9번 조작하여 J를 완성합니다.
- 조이스틱을 왼쪽으로 1번 조작하여 커서를 마지막 문자 위치로 이동시킵니다.
- 마지막 위치에서 조이스틱을 아래로 1번 조작하여 Z를 완성합니다.
따라서 11번 이동시켜 "JAZ"를 만들 수 있고, 이때가 최소 이동입니다.
만들고자 하는 이름 name이 매개변수로 주어질 때, 이름에 대해 조이스틱 조작 횟수의 최솟값을 return 하도록 solution 함수를 만드세요.

제한 사항
name은 알파벳 대문자로만 이루어져 있습니다.
name의 길이는 1 이상 20 이하입니다.
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 조이스틱 {
    public static void main(String[] args) {
        solution("JEROEN");
    }

    // 앞으로 갔을때 최소 값과 뒤로 갔을때 최소 값...
    private static List<Integer> ans = new ArrayList<>();
    private static void dfs(String name, boolean[] check, int idx, int cnt) {
        int esc = 0;
        for(int i = 0; i < check.length; i++) {
            if (!check[i])
                break;
            else {
                if (esc == check.length - 1) {
                    ans.add(cnt);
                    return;
                }
                esc++;
            }
        }

        int idx2 = idx;
        int cnt2 = cnt;
        while(true) {
            idx2++;
            cnt2++;
            if(idx2 == name.length())
                idx2 = 0;
            if(!check[idx2]) {
                check[idx2] = true;
                break;
            }
        }
        dfs(name, check, idx2, cnt2);
        check[idx2] = false;

        idx2 = idx;
        cnt2 = cnt;
        while(true) {
            idx2--;
            cnt2++;
            if(idx2 < 0)
                idx2 = name.length()-1;
            if(!check[idx2]) {
                check[idx2] = true;
                break;
            }
        }
        dfs(name, check, idx2, cnt2);
        check[idx2] = false;
    }

    public static int solution(String name) {
        int answer = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < name.length(); i++)
            sb.append("A");

        for(int i = 0; i < name.length(); i++) {
            int check = name.charAt(i) - sb.charAt(i);
            if(check > 13)
                check = 26 - check;
            answer += check;
        }

        boolean[] check = new boolean[name.length()];
        System.out.println(Arrays.toString(check));
        check[0] = true;
        for(int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == 'A')
                check[i] = true;
        }

        int idx = 0, cnt = 0;
        dfs(name, check, idx, cnt);

        ans.sort(Comparator.naturalOrder());
        answer += ans.get(0);
        System.out.println(ans);
        System.out.println(answer);
        return answer;
    }
}
