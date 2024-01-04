package basic.day4;

import java.util.Scanner;

public class A26Test25 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        A25MySampleMathod.sumMtoN(10,13);
        //System.out.println(sum);

        //메소드가 private으로 정의되면 다른 클래스에서 사용못함
        //boolean isok = A25MySampleMathod. checkJumsu(1:67); //오류
        //자바 (또는 다른 프로그래밍언어)로 코딩할 때
        // 자바에서 제공하는 클래스와 메솓그를 잘 활용하기 
        //2. 필요에 따라 여러분은 개발자가 직접 잘만들어서 사용하기 

        Scanner sc = new Scanner(System.in);
        System.out.println("시작값을 입력하세요>>>>");
        int start =  sc.nextInt();
        System.out.println("마지막 값을 입력하세요>>>>");
        int end = sc.nextInt();

        System.out.println("곱하기 결과" + A25MySampleMathod.multiplyMToN(start, end));



    }
    
}
