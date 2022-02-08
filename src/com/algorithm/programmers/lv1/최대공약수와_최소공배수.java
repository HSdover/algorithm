package com.algorithm.programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 최대공약수와_최소공배수 {
    public static void main(String[] args) {
        solution(18293, 18293);
    }

    public static long[] solution(int n, int m) {
        long[] answer = new long[2];

        List<Integer> nArr = new ArrayList<>();
        List<Integer> mArr = new ArrayList<>();
        int idx = 1;
        while(idx <= Math.sqrt(n) || idx <= Math.sqrt(m)) {
            if(idx <= Math.sqrt(n) && n % idx == 0) {
                nArr.add(idx);
                nArr.add(n / idx);
            }

            if(idx <= Math.sqrt(m) && m % idx == 0) {
                mArr.add(idx);
                mArr.add(m / idx);
            }
            idx++;
        }
        nArr.sort(Comparator.naturalOrder());
        mArr.sort(Comparator.naturalOrder());
        System.out.println(nArr);
        System.out.println(mArr);
        // 최대 공약수
        System.out.println(nArr.size());
        System.out.println(mArr.size());
        int maxVal = 1;
        for(int i = 0; i < nArr.size(); i++) {
            System.out.println("반복" + i);
            for(int j = 0; j < mArr.size(); j++) {
                System.out.println("nArr = " + nArr.get(i));
                System.out.println("mArr = " + mArr.get(j));
                System.out.println(nArr.get(i).equals(mArr.get(j)));
                //Integer 비교 시에는 .equals를 사용하자.
                if(nArr.get(i) == mArr.get(j)) {
                    maxVal = nArr.get(i);
                    System.out.println(maxVal);
                    break;
                }
            }
        }

        // 최소 공배수
        long minVal = 1;
        int nP = 2, mP = 2;
        long comN = n, comM = m;
        while(comN != comM) {
            if(mArr.size() == 2 && nArr.size() == 2) {
                comN = mArr.get(1) * nArr.get(1);
                break;
            }
            if(comN > comM)
                comM = (long)m * (long)mP++;
            else if(comN < comM)
                comN = (long)n * (long)nP++;
            System.out.println("계산중");
            System.out.println(comN);
            System.out.println(comM);
        }
        minVal = comN;
        answer[0] = maxVal;
        answer[1] = minVal;

        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
