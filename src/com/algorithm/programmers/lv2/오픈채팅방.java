package com.algorithm.programmers.lv2;

import java.util.*;

public class 오픈채팅방 {
    public static void main(String[] args) {
        solution();
    }

    public static List<String> solution() {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        List<String> answer = new ArrayList<>();

        // [][0]:기능, [][1]:UID, [][2]:닉네임
        String[][] chatData = new String[record.length][2];
        for(int i = 0; i < record.length; i++)
            chatData[i] = record[i].split(" ");

        // uid만 추출
        Map<String, String> uid = new HashMap<>();
        for(int i = 0; i < chatData.length; i++)
            if(chatData[i].length > 2)
                uid.put(chatData[i][1], chatData[i][2]);

        StringBuilder trans;
        String[] function = {"Enter", "Leave", "Change"};
        for(int i = 0; i < record.length; i++) {
            trans = new StringBuilder();
            if(!chatData[i][0].equals(function[2])) {
                // 닉네임 추가
                trans.append(uid.get(chatData[i][1]) + "님이 ");
                // 동작 추가
                if(chatData[i][0].equals(function[0]))
                    trans.append("들어왔습니다.");
                else if(chatData[i][0].equals(function[1]))
                    trans.append("나갔습니다.");

                answer.add(trans.toString());
            }
        }

        return answer;
    }
}
