package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-data.dat";

    @Override
    public void add(Member member) {
        // 구분자도 제거하고, 자바의 데이터 타입을 그대로 저장
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH,true))){
            dos.writeUTF(member.getId());
            dos.writeUTF(member.getName());
            dos.writeInt(member.getAge());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        List<Member> members = new ArrayList<>();
        try(DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))){
            while (dis.available() > 0){ // 읽을 스트림 확인
                members.add(new Member(dis.readUTF(), dis.readUTF(),dis.readInt())); // 저장된 타입 순서대로 매핑해야함
            }
            return members;
        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
