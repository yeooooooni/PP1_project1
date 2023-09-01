package org.example;

//java 모두의 super class는 Object
public class Student {
    /*
    1. 멤버 변수
    2. 생성자
    3. getters, setters
    4. 맴버 methods
     */
    // int는 보통 계산이 필요한 경우에만 사용 so 학번을 string으로 해라


    private String s_id;
    private String name;

    public Student(String s_id, String name) {
        this.s_id = s_id;
        this.name = name;
    }

    public Student() {

    }


    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student : " + s_id + "-" + name;
    }
}
