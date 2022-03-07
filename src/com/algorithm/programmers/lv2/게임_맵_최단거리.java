package com.algorithm.programmers.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        solution();
    }

    private static int n;
    private static int m;
    private static int[] mr = {1, 0, -1, 0};
    private static int[] mc = {0, 1, 0, -1};
    private static List<Integer> ans = new ArrayList<>();

    private static void dfs(boolean[][] check, int r, int c, int cnt) {
        if(r == n-1 && c == m-1) {
            System.out.println(r + ", " + c);
            ans.add(cnt);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int r2 = r + mr[i];
            int c2 = c + mc[i];

            // r, c가 범위를 벗어나면 넘어간다.
            if(!(r2 >= 0 && r2 < n && c2 >= 0 && c2 < m))
                continue;

            int cnt2 = cnt;
            if(!check[r2][c2]) {
                cnt2++;
                check[r2][c2] = true;
                dfs(check, r2, c2, cnt2);
                check[r2][c2] = false;
            }
            else if(i == 3)
                check[r][c] = true;
        }
    }


    public static int solution() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        int answer = 0;

        n = maps.length;
        m = maps[0].length;
        boolean[][] check = new boolean[n][m];

        check[0][0] = true;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(maps[i][j] == 0)
                    check[i][j] = true;
            }
        }

        for(int i = 0; i < check.length; i++)
            System.out.println(Arrays.toString(check[i]));
        dfs(check, 0, 0, 1);
        ans.sort(Comparator.naturalOrder());

        if(ans.size() == 0)
            answer = -1;
        else
            answer = ans.get(0);

        System.out.println(answer);
        return answer;
    }
}
