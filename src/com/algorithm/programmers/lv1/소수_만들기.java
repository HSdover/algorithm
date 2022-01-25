package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.List;

public class 소수_만들기 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int[] nums = {1,2,7,6,4};
        int answer = 0;

        List<Integer> prime = new ArrayList<Integer>();

        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++)
                for(int k = j + 1; k < nums.length; k++)
                    prime.add(nums[i] + nums[j] + nums[k]);
        }

        System.out.println(prime);
        for(int num : prime) {
            for(int i = 2; i <= Math.sqrt(num); i++) {
                if(num % i == 0)
                    break;
                else if(i == (int) Math.sqrt(num))
                    answer++;
            }
        }
        return answer;
    }
}
