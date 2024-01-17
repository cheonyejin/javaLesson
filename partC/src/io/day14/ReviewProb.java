package io.day14;

import java.io.IOException;
import java.nio.Buffer;
import java.util.Scanner;

import collection.myapp.JavaWord;
import io.javaword.JavaWordList;



public class ReviewProb {
    //2024.01.17.쪽지시험 문제풀이 
    public static void main(String[] args) throws IOException { 
       // prob_8();
       // prob_8_1();
       prob_10();

    }

    public static void prob_8(){    //JavaWordList의 remove()수정-예외처리 추가 
        JavaWordList words =  new JavaWordList("단어장.txt");
        words.fileLoad();
        words.remove(-9);   //words.remove(10)     //2)
        // 개발자가 만드는 예외 :
        //1) 예외가 발생되는 문법오류, 실행오류 없지만 값의 범위를 제한하기 위해 예외 발생
        //2) 기존발생하는 예외를 새로운 내용으로 변경할때 
    }
    /* 실행 결과 :
     * Exception in thread "main" java.util.IllformedLocaleException: 삭제할 번호가 잘못되었습니다
        at io.javaword.JavaWordList.remove(JavaWordList.java:130)       // 3. remove의 130이 오류이다.
        at io.day14.ReviewProb.prob_8(ReviewProb.java:24)               // 2. prob_8의 24로
        at io.day14.ReviewProb.main(ReviewProb.java:15)                 // 1.main의15로 
     */
    
    public static void prob_8_1(){  //JavaWordList의 add()수정-예외처리 추가 
        JavaWordList words =  new JavaWordList("단어장.txt");
        words.fileLoad();
        words.add(new JavaWord("null", "비어있는", 1));  //1)
        // 개발자가 만드는 예외 :
        //1) 예외가 발생되는 문법오류, 실행오류 없지만 값의 범위를 제한하기 위해 예외 발생
        //2) 기존발생하는 예외를 새로운 내용으로 변경할때 
    }
    
/*
 * System.in 표준입출력만 사용하여 최대 20바이트의 문자열을 입력받을 수 있는 코드를 작성해보세요. 
 * 입력받은 내용은 출력으로 확인도 합니다. 총 라인수 3~4 줄 (ReviewProb.java)
 */
    public static void prob_10(){
        byte[] buffer = new byte[20];  
        try {
            System.out.println("입력하세요 >>>");
            int b = System.in.read(buffer); //System.in.read() : day13의 D03에서 배움 //바이트로 입력받기 
            System.out.println("입력 바이트 : " + b);
            System.out.println("입력한 문자열 : " + new String(buffer));
            System.out.println("입력한 문자열 정수로 변환 : " + Integer.parseInt(new String(buffer).trim()));
            //                                                           .trim()은 공백, 엔터 모두 삭제 
        } catch (IOException | NumberFormatException e) {
            //          ||은 논리적인 OR, |은 비트단위 OR이므로 Exception처리는 비트단위 | 를 사용해야된다
            System.out.println("IOException 또는 NumberFormatException 예외를 처리합니다");
            e.printStackTrace();        //예외 원인을 추적해서 *출력* -> 오류 안나고 오류를 보여준다 
        }
    }




    
    
}
