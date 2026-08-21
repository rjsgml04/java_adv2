package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;

public class FileMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-txt.dat";
    private static final String DELIMITER = ",";

    @Override
    public void add(Member member){ // 자동으로 close 호출
        // 구분자 사용, 따로 형변환 해야해서 번거로움 -> 타입에 맞게 변환하는 방식으로 변경 필요
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, UTF_8,true))) { // 데이터 지우지 않고 끝에 계속 추가
            bw.write(member.getId() + DELIMITER + member.getName() + DELIMITER + member.getAge());
            bw.newLine();   // 엔터 - 다음라인으로 넘어가기
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_PATH, UTF_8))){
            String line;

            while((line = br.readLine()) != null){ // 줄 단위로 읽기
                // id1, name1 , 20 <- , 구분자 단위로 짤라서 읽을 수 있음
                String[] memberData = line.split(DELIMITER);
                members.add(new Member(memberData[0], memberData[1], Integer.valueOf(memberData[2])));
            }

            return members;
        } catch (FileNotFoundException e){
          return new ArrayList<>(); // 아무것도 없는 상태에서 조회할때 반환
        } catch (IOException e){
            throw new RuntimeException();
        }
    }
}
