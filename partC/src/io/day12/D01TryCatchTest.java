package io.day12;

import java.util.Scanner;

public class D01TryCatchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요. ");

        // 예외 처리 구문 : 비정상적인 종료에 대해 사용자에게 전달. 또는 이후의 명령을 실행.
        // NumberFormatException, IndexOutOfBoundsException은 예외처리가 강제가 아닙니다. => UncheckedException
        try {
            // 예외 가능성이 있는 명령문 작성
            // int number = Integer.parseInt(sc.nextLine());
            // System.out.println("입력한 값 : " + number);
            indexException();
        } catch (NumberFormatException e) { // e : 처리할 예외 종류 (Exception : 모든 예외)
            // 예외가 발생할 때 실행할 명령
            System.out.println("숫자만 입력하세요.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("인덱스 범위는 배열의 길이-1 까지 입니다.");
        }

        int [] arrays = {11, 22, 33, 44, 55};
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        // System.out.println(arrays.length);

        System.out.println("마지막 명령어 입니다.");

        sc.close();
    }

    public static void indexException() {
        int[] arrays = {11, 22, 33, 44, 55};
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[arrays.length]);
    }

    public static void numberException() {
        int[] arrays = {11, 22, 33, 44, 55};
        System.out.println(arrays[0]);
        System.out.println(arrays[1]);
        System.out.println(arrays[arrays.length]);
    }
}

