package object.day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class B01MyclassMain {

    /**
     * @param args
     */
    public static void main(String[] args) {
        
        /*정의된 클래스 Myclass1으로 객체를 만듭니다.
        객체를 만들때는 new 연산 사용하기   */

        MyClass1 my1 = new MyClass1();  //객체란 데이터 덩어리 , 저장할 메모리 확보 
        //MyClass1()는 생성자 메소드 , 무조건 클래스 이음과 같다, 메모리에 공간을 확보하며 동시에 실행 


        System.out.println(my1.field1); //String
        System.out.println(my1.field2); //int
        System.out.println(my1.field3); //double배열

        my1.field1 = "Hi모모";
        my1.field2 = 999;
        my1.field3 = new double[5];

        System.out.println(my1.field1); //String
        System.out.println(my1.field2); //int
        System.out.println(my1.field3); //double배열 
        System.out.println(my1.field3.length); //double배열의 크기  
        //System.out.println(Arrays.toString(my1.field1));

        MyClass1 my2 = new MyClass1();
        my2.field1 = "점심 먹으러 갑시다.";
        my2.field2 = 12345;
        my2.field3 = new double[]{34.12,23.99,6.78}; //새로운 더블 배열데이터 크기는 3

        System.out.println(my2.field1.hashCode());

    }
    
}
