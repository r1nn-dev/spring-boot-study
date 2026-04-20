package com.example.templateproject;

public class Person {
    private String name;
    private int age;
    private String address;

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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
