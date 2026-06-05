package com.example.templateproject.controller;

public class Person {

    // 선언
    private final String name;
    private final int age;
    private final String address;

    // Constructor: 우클릭 > Generate > Constructor(생성자) > [Shift + 선택]
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    // Getter: 우클릭 > Generate > Getter > [Shift + 선택]
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // 객체 자체를 출력할 때 사용할 문자열 형식
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }

}
