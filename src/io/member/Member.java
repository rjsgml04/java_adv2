package io.member;

import java.io.Serializable;

public class Member implements Serializable {
    // 기능은 딱히 없고 직렬화 객체라는 의미로 사용
   // 해당 인터페이스 없이 직렬화 시도하면 예외 발생

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;

    private Integer age;
    public Member() {
    }

    public Member(String id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
