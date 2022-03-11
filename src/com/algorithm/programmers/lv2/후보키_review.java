package com.algorithm.programmers.lv2;

import java.util.*;

public class 후보키_review {
    public static void main(String[] args) {
        후보키_review test = new 후보키_review();
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"}
        ,{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"}
        ,{"600","apeach","music","2"}};
        test.solution(relation);
    }

    ArrayList<HashSet<Integer>> candidateKey;
    String Table[][];
    int length;
    int answer;

    public int solution(String[][] relation) {
        answer = 0;
        candidateKey = new ArrayList<>();
        Table = relation;
        length = relation[0].length;
        for(int i = 0; i <= length; i++)
            makeSet(-1, i, 0, new HashSet<Integer>());

        System.out.println(answer);
        return answer;
    }

    private void makeSet(int idx, int target, int count, HashSet<Integer> set) {
        if(count == target) {
            if(!isUnique(set))
                return;

            for(HashSet<Integer> key : candidateKey) {
                if(set.containsAll(key)) {
                    return;
                }
            }
            candidateKey.add(set);
            answer++;
            return;
        }

        for(int i = idx + 1; i < length; i++) {
            HashSet<Integer> newSet = new HashSet<>(set);
            newSet.add(i);
            makeSet(i, target, count + 1, newSet);
        }
    }

    public boolean isUnique(HashSet<Integer> set) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < Table.length; i++) {
            String temp = "";
            for(int idx : set) {
                temp += Table[i][idx];
            }
            if(!list.contains(temp)) {
                list.add(temp);
            }
            else
                return false;
        }
        return true;
    }
}
