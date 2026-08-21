package io.member.impl;

import io.member.Member;
import io.member.MemberRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ObjectMemberRepository implements MemberRepository {

    private static final String FILE_PATH = "temp/members-obj.dat";

    @Override
    public void add(Member member) {
        List<Member> members = findAll(); // 회원을 우선 찾음
        members.add(member);

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))){
            oos.writeObject(members); // 단일 객체만 저장할 수 없어서 List를 통으로 넘겨버림
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Member> findAll() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))){
            Object findObject = ois.readObject(); // 저장한 객체를 통으로 불러올 수 있음
            return (List<Member>) findObject;
        } catch (FileNotFoundException e){
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
