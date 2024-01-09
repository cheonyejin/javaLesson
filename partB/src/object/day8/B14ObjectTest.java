package object.day8;

import object.day7.Diamond;
import object.day7.Shape;
import object.day7.Square;
import object.day7.Triangle;

public class B14ObjectTest {
    public static void main(String[] args) {
        
            //모든 자바 클래스의 부모는 Object타입
            Object ob1 = new String("Hello World");
            Object ob2 = new Diamond();
            Object ob3 = 3;             //int정수는 Integer객체로 변경-> Object에 속한다
            //기본형 타입은 Wrapper 클래스로 객체로 변경되서  Object로 캐스팅
            // Byte, Character, Short, :pnh, Integer, Float, double
            //다른 자료구조 List, Amp, Set 등은 객체타입만 다룹니다.
            
        
            //Object의 메소드는 ? 모든 자바 클래스가 상속받고 있다.
            //getClass, toString, hashCode, equals, 
            //String클래스 equals는 Object 메소드 재정의 
            //그 이외는 스레드 메소드 
            System.out.println("getClass는 클래스의 타입 정보를 리턴합니다");
            //getName은 클래스 타입 정보 중 클래스 이름 리턴
            System.out.println("\tob1.getClass().getName() : " + ob1.getClass().getName());
            System.out.println("\tob2.getClass().getName() : " + ob2.getClass().getName());
            System.out.println("\tob3.getClass().getName() : " + ob3.getClass().getName());


            System.out.println("\nhashcode는 객체의 참조값(식별값)을 리턴");
            System.out.println("\t ob1.hashcode : " + ob1.hashCode() + " , " +"Integer.toHexString(ob1.hashCode()) : "+ Integer.toHexString(ob1.hashCode()));
            System.out.println("\t ob2.hashcode : " + ob2.hashCode() + " , " +"Integer.toHexString(ob2.hashCode()) : "+ Integer.toHexString(ob2.hashCode()));
            System.out.println("\t ob3.hashcode : " + ob3.hashCode() + " , " +"Integer.toHexString(ob3.hashCode()) : "+ Integer.toHexString(ob3.hashCode()));


            System.out.println("\ntoString확인");
            System.out.println("\tob1.toString() : " + ob1.toString());     //Stirng은 toString재정의
            System.out.println("\tob2.toString() : " + ob2.toString());     //Object toString의 기본값 출력
            System.out.println("\tob3.toString() : " + ob3.toString());     //Integer는 toString 재정의
            System.out.println("\tob1 : " + ob1);   //toString메소드는 생략 가능하다 즉, 출력이 같다
            System.out.println("\tob2 : " + ob2);
            System.out.println("\tob3 : " + ob3);


            
            //객체 만들기 
            System.out.println("우리가 만든 클래스의 toString 재정의 확인");
            Shape sh2 = new Shape("아직모름", 25,20);
            Shape diamond = new Diamond();     //인스턴스 필드는 초기값이 0
            Shape square = new Square();
            Shape triangle = new Triangle("삼각형", 20,30 , 65);

            //toString은 생략 가능한거 배웠지?
            System.out.println("\tsh2 : " + sh2);
            System.out.println("\tdiamond : " + diamond);       //자식 클래스Diamond가 정의한 toString
            System.out.println("\tsquare : " + square);         //부모 클래스Shape가 정의한 toStirng
            System.out.println("\ttriangle : " + triangle);     //부모 클래스Shape가 정의한 toStirng


        }
}
