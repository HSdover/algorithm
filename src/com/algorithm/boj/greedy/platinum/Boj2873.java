package com.algorithm.boj.greedy.platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//문제
//상근이는 우리나라에서 가장 유명한 놀이 공원을 운영하고 있다. 이 놀이 공원은 야외에 있고, 다양한 롤러코스터가 많이 있다.
//
//어느 날 벤치에 앉아있던 상근이는 커다란 황금을 발견한 기분이 들었다. 자신의 눈 앞에 보이는 이 부지를 구매해서 롤러코스터를 만든다면, 세상에서 가장 재미있는 롤러코스터를 만들 수 있다고 생각했다.
//
//이 부지는 직사각형 모양이고, 상근이는 R행 C열의 표 모양으로 나누었다. 롤러코스터는 가장 왼쪽 위 칸에서 시작할 것이고, 가장 오른쪽 아래 칸에서 도착할 것이다. 롤러코스터는 현재 있는 칸과 위, 아래, 왼쪽, 오른쪽으로 인접한 칸으로 이동할 수 있다. 각 칸은 한 번 방문할 수 있고, 방문하지 않은 칸이 있어도 된다.
//
//각 칸에는 그 칸을 지나갈 때, 탑승자가 얻을 수 있는 기쁨을 나타낸 숫자가 적혀있다. 롤러코스터를 탄 사람이 얻을 수 있는 기쁨은 지나간 칸의 기쁨의 합이다. 가장 큰 기쁨을 주는 롤러코스터는 어떻게 움직여야 하는지를 구하는 프로그램을 작성하시오.
//
//입력
//첫째 줄에 R과 C가 주어진다. (2 ≤ R, C ≤ 1000) 둘째 줄부터 R개 줄에는 각 칸을 지나갈 때 얻을 수 있는 기쁨이 주어진다. 이 값은 1000보다 작은 양의 정수이다.
//
//출력
//첫째 줄에 가장 가장 큰 기쁨을 주는 롤러코스터는 가장 왼쪽 위 칸부터 가장 오른쪽 아래 칸으로 어떻게 움직이면 되는지를 출력한다. 위는 U, 오른쪽은 R, 왼쪽은 L, 아래는 D로 출력한다. 정답은 여러 가지 일 수도 있다.
public class Boj2873 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
        int R = Integer.parseInt(st1.nextToken());
        int C = Integer.parseInt(st1.nextToken());
        int[][] h = new int[R][C];

        StringBuilder r = new StringBuilder();
        StringBuilder l = new StringBuilder();
        StringBuilder d = new StringBuilder();
        StringBuilder u = new StringBuilder();
        StringBuilder rol = new StringBuilder();

        int inR = 0;
        int inC = 1;

        for (int i = 0; i < R; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < C; j++) {
                h[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int min = h[0][1];

        //행, 열이 하나라도 홀수인 경우는 모든 칸을 지날 수 있다.
        //행만 홀수인 경우(행, 열이 둘 다 홀수인 경우도 포함)
        if(R % 2 == 1) {
            for(int i = 0; i < C - 1; i++) {
                r.append("R");
                l.append("L");
            }
            for(int i = 0; i < R / 2; i++) {
                rol.append(r + "D" + l + "D");
            }
            rol.append(r);
        }
        //열만이 홀수인 경우
        else if(C % 2 == 1) {
            for(int i = 0; i < R - 1; i++) {
                d.append("D");
                u.append("U");
            }
            for(int i = 0; i < C / 2; i++) {
                rol.append(d + "R" + u + "R");
            }
            rol.append(d);
        }
        else {
            //배열 내 최소값 찾기
           for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (!((i == 0 && j == 0) || (i == R - 1 && j == C - 1))) {
                        if ((i % 2 == 0 && j % 2 == 1 && min > h[i][j]) || (i % 2 == 1 && j % 2 == 0 && min > h[i][j])) {
                            min = h[i][j];
                            inR = i;
                            inC = j;
                        }
                    }
                }
            }
           StringBuilder m1 = new StringBuilder();
           StringBuilder m2 = new StringBuilder();

            for(int i = 0; i < C - 1; i++) {
                r.append("R");
                l.append("L");
            }
           for(int i = 0; i < inR / 2; i++)
               m1.append(r + "D" + l + "D");
           for(int i = 0; i < inC / 2; i++)
               m1.append("DRUR");
           if(inC % 2 == 0)
               m1.append("RD");
           else
               m1.append("DR");
           for(int i = (inR / 2) + 1; i < R / 2; i++)
               m2.append(r + "D" + l + "D");
            for(int i = (inC / 2) + 1; i < C / 2; i++)
                m2.append("DRUR");
            rol.append(m1.append(m2.reverse()));
        }
        System.out.println(rol);
//        String r = "R";
//        String l = "L";
//        String d = "D";
//        String u = "U";
//        String rol = "";
//
//        int min = h[0][1];
//        int inR = 0;
//        int inC = 1;
//
//        if (R % 2 == 1) {
//            for (int i = 0; i < C - 2; i++) {
//                r += "R";
//                l += "L";
//            }
//            for (int i = 0; i < R / 2; i++) {
//                rol += r + d + l + d;
//            }
//            rol += r;
//        } else if (C % 2 == 1) {
//            for (int i = 0; i < R - 2; i++) {
//                d += "D";
//                u += "U";
//            }
//            for (int i = 0; i < C / 2; i++) {
//                rol += d + r + u + r;
//            }
//            rol += d;
//        } else {
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    if (!((i == 0 && j == 0) || (i == R - 1 && j == C - 1))) {
//                        if ((i % 2 == 0 && j % 2 == 1 && min > h[i][j]) || (i % 2 == 1 && j % 2 == 0 && min > h[i][j])) {
//                            min = h[i][j];
//                            inR = i;
//                            inC = j;
//                        }
//                    }
//                }
//            }
//            String m1 = "";
//            String m2 = "";
//
//            for (int i = 0; i < C - 2; i++) {
//                r += "R";
//                l += "L";
//            }
//            for(int i = 0; i < inR / 2; i++)
//                m1 += r + d + l + d;
//            for(int i = R/2; i > inR / 2 + 1; i--) {
//                m2 += d + l + d + r;
//            }
//
////            for(int i = inR / 2; i < R / 2; i++) {
////                if(cnt == 0 || cnt==1 || cnt==R-1 || cnt==R-2) {
////                    cnt = -1;
////                    continue;
////                }
////                m2 += d + l + d + r;
////            }
//
//            for(int i = 0; i < inC/2; i++) {
//                m1 += "DRUR";
//            }
//            if(inR % 2 == 0) {
//                if(inC == C - 1)
//                    m1 += "DR";
//                else {
//                    m1 += "DRR";
//                }
//            }
//            else {
//                if((inR == R-1 || inR == R-2)&&(inC == C-1 || inC == C-2))
//                    m1 += "RD";
//                else {
//                    if(inC == C - 2)
//                        m1 += "RD";
//                    else
//                        m1 += "RDR";
//                }
//            }
//
//            int cnt = inC/2;
//            for(int i = inC / 2; i < C / 2; i++) {
//                if(cnt == 0 || cnt==1) {
//                    cnt = -1;
//                    continue;
//                }
//                if(inC == C - 1 || inC == C - 2)
//                    break;
//                if(i == C/2 - 1) {
//                    m1 += "URD";
//                    break;
//                }
//                m1 += "URDR";
//            }
//            rol = m1 + m2;
//        }
//        System.out.println(rol);
    }
}
