package io.day13;

import java.io.IOException;
//바이트기반 스트림 연습해보기
//D03StandardIOTest을 풀어서 써봄
//표준 입출력 테스트
//키보드 입력 : new Scanner(System.in) 또는 System.console().readLine()
public class D03StandardIOTestReview {
    
    public static void main(String[] args) {
        int b;
        System.out.println("입력하세요. ↓ ");
        //표준입출력은 모든 글자가 2바이트.=> 윈도우 터미널 인코딩 방식
        try{
            b=System.in.read(); //1바이트 입력받고 
            System.out.println(Integer.toHexString(b)); //출력하고
           
            b=System.in.read();
            System.out.println(Integer.toHexString(b));

           
            b=System.in.read();
            System.out.println(Integer.toHexString(b));

           
            b=System.in.read();
            System.out.println(Integer.toHexString(b));

            b=System.in.read();
            System.out.println(Integer.toHexString(b));

           
            b=System.in.read();
            System.out.println(Integer.toHexString(b));

            
        }catch(IOException e){
            System.out.println("예외 : " + e.getMessage());
        }

    }
}
/*
 * 입력하세요. ↓ 
12345678
31
32
33
34
35
36              총 6개의 read문을써서 6개만 나옴
 */

/* 한글은 2바이트여서 b0 a1을 더해야 가 이다.
입력하세요. ↓ 
가각간갇갈갉
b0
a1
b0
a2
b0
a3
 */