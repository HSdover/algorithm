package com.algorithm.programmers.lv2;

public class 타겟_넘버 {
    public static void main(String[] args) {
        solution();
    }

    private static void dfs(int idx, int[] numbers, int sum, int target) {
        if(idx == numbers.length-1) {
            if(sum == target) {
                answer++;
                return;
            }
            else
                return;
        }
        idx++;

        int nSum = sum + numbers[idx];
        dfs(idx, numbers, nSum, target);
        nSum = sum - numbers[idx];
        dfs(idx, numbers, nSum, target);
    }

    static int answer = 0;

    public static int solution() {
        int[] numbers = {1, 1, 1, 1, 1};
        int target = 3;

        int sum = numbers[0];
        int idx = 0;
        dfs(idx, numbers, sum, target);
        sum = -numbers[0];
        dfs(idx, numbers, sum, target);
        System.out.println(answer);
        return answer;
    }
}
