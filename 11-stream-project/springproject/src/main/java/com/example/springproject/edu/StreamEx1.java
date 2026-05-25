package com.example.springproject.edu;

import java.util.Arrays;
import java.util.List;

// 이름이 A로 시작하는 이름을 찾아 출력하기
public class StreamEx1 {

    public static void main(String[] args) {

        // 문자열 List 생성
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");

        // 1. forEach문 사용 - 조건문
        for (String name : names) {
            if (name.startsWith("A")) System.out.println(name);
        }

        // 2. stream 이용 - 람다 표현식
        // 2-1) Stream 생성
        // 2-2) 중간 연산: filtering된 Stream 생성
        // 2-3) 최종 연산
        names.stream().filter(name -> name.startsWith("A")).forEach(name -> System.out.println(name));

        // 3. stream 이용 - 메서드 참조 (람다 표현식을 간소화한 문법)
        // 3-1) Stream 생성
        // 3-2) 중간 연산: filtering된 Stream 생성
        // 3-3) 최종 연산: 메서드 참조 - `객체 :: 인스턴스 메서드`
        names.stream().filter(name -> name.startsWith("A")).forEach(System.out::println);
    }
}
