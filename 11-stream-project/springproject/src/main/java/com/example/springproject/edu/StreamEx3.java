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

        List<String> names = Arrays.asList("Tom", "Jerry", "Spike", "Tyke", "Alice", "Bob", "Tommy", "Trump");

        System.out.println("===========ForEach===========");
        List<String> filteredNames = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 3) filteredNames.add(name);
        }

        List<String> upperCaseNames = new ArrayList<>();
        for (String name : filteredNames) upperCaseNames.add(name.toUpperCase());

        Collections.sort(upperCaseNames);

        for (String name : upperCaseNames) {
            System.out.print(name + " ");
        }

        System.out.println("\n===========Stream===========");
        names.stream()
                .filter(name -> name.length() > 3)
                .map(name -> name.toUpperCase())
                .sorted()
                .forEach(name -> System.out.print(name + " "));
    }
}
