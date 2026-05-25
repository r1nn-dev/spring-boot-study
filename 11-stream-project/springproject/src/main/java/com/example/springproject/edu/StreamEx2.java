package com.example.springproject.edu;

import java.util.*;
import java.util.stream.Collectors;

/*
* 1~10 사이의 중복된 정수값이 들어있는 List에서
* 중복을 제거하고 3의 배수가 아닌 수를 출력하기
* */
public class StreamEx2 {

    public static void main(String[] args) {

        List<Integer> integerList = Arrays.asList(1, 2, 3, 1, 2, 3, 4, 5, 7, 7, 8, 9, 10, 10);

        // 1. forEach문 사용

        // ArrayList 생성
        // HashSet - 중복 제거
        List<Integer> uniqueNumber = new ArrayList<>(new HashSet<>(integerList));
        List<Integer> filteredList = new ArrayList<>();

        // 3의 배수가 아닌 수 필터링
        for (Integer num : uniqueNumber) {
            if (num % 3 != 0) filteredList.add(num);
        }

        System.out.println(filteredList);

        // 2. Stream 사용
        // 2-1) Stream 생성
        // 2-2) 중간 연산 - 중복 제거, 3의 배수가 아닌 수
        // 2-3) 최종 연산 - Stream -> List로 type 변환 후 수집
        System.out.println(
                integerList.stream().distinct()               // 중복 제거 -> (1, 2, 3, 4, 5, 7, 8, 9, 10)
                        .filter(num -> num % 3 != 0)   // 3의 배수가 아닌 수 -> (1, 2, 4, 5, 7, 8, 10)
                        .collect(Collectors.toList())         // List로 변환 -> [1, 2, 4, 5, 7, 8, 10]
        );
    }
}
