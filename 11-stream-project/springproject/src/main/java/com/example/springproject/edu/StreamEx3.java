package com.example.springproject.edu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 이름의 길이가 3개 초과인 이름에 대해
* 모두 대문자로 바꾼 후 오름차순으로 정렬하여 출력하기
* */
public class StreamEx3 {

    public static void main(String[] args) {

        // 문자열 List 생성
        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Alice", "Bob", "Tommy", "Trump");

        // 1. forEach문 사용

        System.out.println("===========ForEach===========");
        // ArrayList 생성
        List<String> filteredNames = new ArrayList<>();
        // forEach문
        for (String name : names) {
            if (name.length() > 3) filteredNames.add(name);
        }

        // ArrayList 생성
        List<String> upperCaseNames = new ArrayList<>();
        // 대문자로 변환
        for (String name : filteredNames) {
            upperCaseNames.add(name.toUpperCase());
        }

        // 오름차순 정렬
        Collections.sort(upperCaseNames);
        for (String name : upperCaseNames) {
            System.out.print(name + " ");
        }

        // 2. Stream 사용
        System.out.println("\n===========Stream===========");
        // 2-1) Stream 생성
        // 2-2) 중간 연산 - 이름의 길이가 3개 초과인 이름 필터링, 대문자 변환
        // 2-3) 최종 연산 - 오름차순 정렬
        names.stream()
                .filter(name -> name.length() > 3)   // {"Jerry", "Spike", "Tyke", "Alice", "Tommy", "Trump"}
                .map(name -> name.toUpperCase())     // {"JERRY", "SPIKE", "TYKE", "ALICE", "TOMMY", "TRUMP"}
                .sorted()                                  // {"ALICE", "JERRY", "SPIKE", "TOMMY", "TRUMP", "TYKE"}
                .forEach(name -> System.out.print(name + " "));
    }
}
