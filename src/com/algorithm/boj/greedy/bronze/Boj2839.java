package com.algorithm.boj.greedy.bronze;

import java.util.Scanner;

public class Boj2839 {
    //문제
    //상근이는 요즘 설탕공장에서 설탕을 배달하고 있다. 상근이는 지금 사탕가게에 설탕을 정확하게 N킬로그램을 배달해야 한다. 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다. 봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
    //
    //상근이는 귀찮기 때문에, 최대한 적은 봉지를 들고 가려고 한다. 예를 들어, 18킬로그램 설탕을 배달해야 할 때, 3킬로그램 봉지 6개를 가져가도 되지만, 5킬로그램 3개와 3킬로그램 1개를 배달하면, 더 적은 개수의 봉지를 배달할 수 있다.
    //
    //상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때, 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
    //
    //입력
    //첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
    //
    //출력
    //상근이가 배달하는 봉지의 최소 개수를 출력한다. 만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int sugar = sc.nextInt();
        int cnt = 0;

        //입력범위값
        if (sugar < 3 || sugar > 5000)
            return;

        //5kg으로 한 번에 담음(최적의 해)
        if(sugar % 5 == 0)
            cnt = sugar / 5;
        else {
            while(sugar > 0){

                //3kg 봉지가 적게 들어가야 하므로 3kg를 빼줌 3kg 봉지로만 처리되는 경우도 처리해줌
                sugar -= 3;

                //3kg 봉지 개수 추가
                cnt++;

                //3kg 봉지 수 빼고 다시 최적의 봉지 수 구함
                if(sugar % 5 == 0){
                    cnt += sugar / 5;
                    break;
                }
            }
        }
        //3과 5로 나눌 수 없는 경우
        if(sugar < 0)
            cnt = -1;

        System.out.print(cnt);
    }
}
