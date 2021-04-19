package com.mrhi2020.ex84firebasedb;

//[VO : Value Object - 값을 저장하는 목적의 클래스 지칭 ]
public class PersonVO {
    public String name;
    public int age;
    public String address;

    //Firebase에서 동작되려면 반드시 생성자
    public PersonVO() {
    }

    public PersonVO(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
}
