package com.example.springproject.edu;

import java.util.Arrays;
import java.util.List;

// 각 데이터의 짝수를 찾아서, 그것을 곱한 후, 모두 더하는 결과 가져오기
public class StreamEx4 {

    public static void main(String[] args) {

        // 1. 짝수만 필터링한 뒤 제곱하고 합계 구하기
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        int sumOfSquares = numbers.stream()
                .filter(num -> num % 2 == 0)                             // 2, 4, 6, 8, 10
                .map(num -> num * num)                                   // 4, 16, 36, 64, 100
                .reduce(0, (prev, next) -> prev + next);   // 0+4+16+36+64+100=220
        System.out.println("Sum of squares of even numbers: " + sumOfSquares);  // 220

        // 2. 길이가 4 이상인 이름만 대문자로 변환한 뒤 문자열로 누적하기
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        String result = names.stream()
                .filter(name -> name.length() >= 4)    // "Alice", "Charlie", "David"
                .map(name -> name.toUpperCase())       // "ALICE", "CHARLIE", "DAVID"
                .reduce("", (prev, next) -> prev.concat(next + " "));
                                                             // "ALICE" "CHARLIE" "DAVID"
        System.out.println(result);                          // ALICE CHARLIE DAVID
    }
}
