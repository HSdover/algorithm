package com.algorithm.programmers.lv1;

public class 체육복 {
    public static void main(String[] args) {
        solution();
    }

    public static int solution() {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};
        int answer = 0;

        int[] stu = new int[n];
        //모든 학생에게 체육복 1지급
        for(int i = 0; i < n; i++)
            stu[i] = 1;
        //체육복이 없어진 학생
        for(int i = 0; i < lost.length; i++)
            stu[lost[i]-1] -= 1;
        //여분 체육복을 추가
        for(int i = 0; i < reserve.length; i++)
            stu[reserve[i]-1] += 1;

        //수업 참여 가능한 학생 카운트
        for(int i = 0; i < n; i++) {
            if(stu[i] != 0)
                answer++;
            else if(stu[i] == 0 && (stu[i-1] == 2 && i != 0)) {
                stu[i-1] -= 1;
                stu[i] += 1;
                answer++;
            }
            else if(stu[i] == 0 && (stu[i+1] == 2 && i != n-1)) {
                stu[i+1] -= 1;
                stu[i] += 1;
                answer++;
            }
        }
        return answer;
    }
}
