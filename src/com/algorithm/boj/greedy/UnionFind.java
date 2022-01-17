package com.algorithm.boj.greedy;

/**
 * - 유니온-파인드 알고리즘
 * 유니온-파인드 알고리즘이란
 */
public class UnionFind {

    // 부모 노드를 찾는 함수
    static int getParent(int[] parent, int x) {
        if(parent[x] == x)
            return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 두 부모 노드를 합치는 함수
    static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    static int findParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b)
            return 1;
        return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[11];
        for(int i = 0; i < 10; i++)
            a[i] = i;

        unionParent(a, 2, 3);
        unionParent(a, 1, 2);

        unionParent(a, 5, 6);
        unionParent(a, 6, 7);

        System.out.println(getParent(a, 3));
        System.out.println(findParent(a, 1, 3));
        System.out.println(findParent(a, 3, 5));
    }


}
