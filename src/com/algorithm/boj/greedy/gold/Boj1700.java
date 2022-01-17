package com.algorithm.boj.greedy.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
//문제
//기숙사에서 살고 있는 준규는 한 개의 멀티탭을 이용하고 있다. 준규는 키보드, 헤어드라이기, 핸드폰 충전기, 디지털 카메라 충전기 등 여러 개의 전기용품을 사용하면서 어쩔 수 없이 각종 전기용품의 플러그를 뺐다 꽂았다 하는 불편함을 겪고 있다. 그래서 준규는 자신의 생활 패턴을 분석하여, 자기가 사용하고 있는 전기용품의 사용순서를 알아내었고, 이를 기반으로 플러그를 빼는 횟수를 최소화하는 방법을 고안하여 보다 쾌적한 생활환경을 만들려고 한다.
//
//예를 들어 3 구(구멍이 세 개 달린) 멀티탭을 쓸 때, 전기용품의 사용 순서가 아래와 같이 주어진다면,
//
//키보드
//헤어드라이기
//핸드폰 충전기
//디지털 카메라 충전기
//키보드
//헤어드라이기
//키보드, 헤어드라이기, 핸드폰 충전기의 플러그를 순서대로 멀티탭에 꽂은 다음 디지털 카메라 충전기 플러그를 꽂기 전에 핸드폰충전기 플러그를 빼는 것이 최적일 것이므로 플러그는 한 번만 빼면 된다.
//
//입력
//첫 줄에는 멀티탭 구멍의 개수 N (1 ≤ N ≤ 100)과 전기 용품의 총 사용횟수 K (1 ≤ K ≤ 100)가 정수로 주어진다. 두 번째 줄에는 전기용품의 이름이 K 이하의 자연수로 사용 순서대로 주어진다. 각 줄의 모든 정수 사이는 공백문자로 구분되어 있다.
//
//출력
//하나씩 플러그를 빼는 최소의 횟수를 출력하시오.
public class Boj1700 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int setOff = 0;
        ArrayList<Integer> hole = new ArrayList<>();
        int[] elec = new int[K];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < K; i++)
            elec[i] = Integer.parseInt(st.nextToken());

        // 1차 도전
//        int index = N - 1;
//        int setCnt = 1;
//        int[] kIn = new int[N];

        // 2차 도전
        for(int i = 0; i < K; i++) {
            // 2차 도전
            //콘센트가 비어있고 새로운 기기를 꽂아야할때
            if(hole.size() < N && hole.contains(elec[i]) == false)
                hole.add(elec[i]);
            //콘센트가 비어있지 않고 새로운 기기를 꽂아야할때
            else if(hole.size() == N && hole.contains(elec[i]) == false) {
                // 뺄 콘센트가 있는 자리
                int index = 0;
                // 꽂혀있던 기기들이 뒤에 꽂혀있을경우 인덱스의 모음
                ArrayList<Integer> elecIndex = new ArrayList<>();
                // 꽂혀있는 기기가 뒤에 있는지 전체 탐색
                for(int j = 0; j < N; j++) {
                    for(int k = i + 1; k < K; k++) {
                        // 꽂혀있는 기기가 이후에 쓰일 경우
                        if(hole.get(j) == elec[k]) {
                            elecIndex.add(k);
                            // 꽂혀있는 기기들이 뒤에 전부다 쓰일 경우
                            if(elecIndex.size() == N) {
                                // 오름차순으로 정렬시 인덱스의 가장 뒤에 재사용되는 콘센트 인덱스가 있다.
                                Collections.sort(elecIndex);
                                // 가장 뒤에 재사용되는 콘센트 인덱스를 뽑아준다.
                                index = hole.indexOf(elec[elecIndex.get(N - 1)]);
                            }
                            break;
                        }
                        // 꽂혀있는 기기가 이후에 안쓰일 경우
                        if(k == K - 1)
                            index = j;
                    }
                }
                // 걸러낸 콘센트를 뽑음
                hole.remove(index);
                // 새로운 콘센트 꽂음
                hole.add(elec[i]);
                // 뽑은 회수 증가
                setOff++;
                // 1차 도전
//                for(int j = 0; j < N; j++)
//                    System.out.println(hole.get(j));
//                for(int j = 0; j < N; j++ ) {
//                    for(int k = i + 1; k < K; k++) {
//                        if(hole.get(j) == elec[k]) {
//                            index = N - 1;
//                            kIn[j] = k;
//                            setCnt++;
//                            if(setCnt == N) {
//                                Arrays.sort(kIn);
//                                index = hole.indexOf(elec[kIn[N-1]]);
//                                setCnt = 1;
//                            }
//                            continue;
//                        }
//                        index = j;
//                    }
//                }
//                hole.remove(index);
//                setOff++;
//                hole.add(elec[i]);
            }
        }
        System.out.println(setOff);
    }
}
