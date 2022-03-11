package com.algorithm.programmers.lv2;

import java.util.*;

public class 게임_맵_최단거리 {
    public static void main(String[] args) {
        게임_맵_최단거리 test = new 게임_맵_최단거리();
        test.solution();
    }


    // DFS로는 효율성 테스트 통과 불가 BFS를 이용하자
//    private static List<Integer> ans = new ArrayList<>();

//    private static void dfs(boolean[][] check, int r, int c, int cnt) {
//        if(r == n-1 && c == m-1) {
//            System.out.println(r + ", " + c);
//            ans.add(cnt);
//            return;
//        }
//
//        for(int i = 0; i < 4; i++) {
//            int r2 = r + mr[i];
//            int c2 = c + mc[i];
//
//            // r, c가 범위를 벗어나면 넘어간다.
//            if(!(r2 >= 0 && r2 < n && c2 >= 0 && c2 < m))
//                continue;
//
//            int cnt2 = cnt;
//            if(!check[r2][c2]) {
//                cnt2++;
//                check[r2][c2] = true;
//                dfs(check, r2, c2, cnt2);
//                check[r2][c2] = false;
//            }
//        }
//    }

    int n;
    int m;
    int[] mr = {1, 0, -1, 0};
    int[] mc = {0, 1, 0, -1};
    boolean[][] check;

    public int bfs(int r, int c, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(r, c, 1));
        check[r][c] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            if(node.x == n - 1 && node.y == m-1) return node.cost;

            for(int i = 0; i < 4; i++) {
                int nr = node.x + mr[i];
                int nc = node.y + mc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if(maps[nr][nc] == 1 && !check[nr][nc]) {
                        check[nr][nc] = true;
                        q.offer(new Node(nr, nc, node.cost + 1));
                    }
                }
            }
        }
        return -1;
    }

    public class Node {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public int solution() {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        int answer = 0;

        n = maps.length;
        m = maps[0].length;
        check = new boolean[n][m];

        answer = bfs(0, 0, maps);
        System.out.println(answer);
        return answer;

        // maps에 있는데 왜 만들었냐..
//        check[0][0] = true;
//        for(int i = 0; i < n; i++) {
//            for(int j = 0; j < m; j++) {
//                if(maps[i][j] == 0)
//                    check[i][j] = true;
//            }
//        }


        // DFS
//        ans.sort(Comparator.naturalOrder());
//        if(ans.size() == 0)
//            answer = -1;
//        else
//            answer = ans.get(0);
    }
}
