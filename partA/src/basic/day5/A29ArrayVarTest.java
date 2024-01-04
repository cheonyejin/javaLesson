package basic.day5;

import java.lang.reflect.Array;
import java.util.Arrays;

public class A29ArrayVarTest {


    // 기본형과 참조형 변수의 비교 


    public static void main(String[] args) {
        int[] iArray = { 1, 2, 3, 4, 5 };
        double[] dArray = new double[5];
        char[] cArray = new char[5];
        cArray[0] = 'j';        
        cArray[1] = 'a';       
        cArray[2] = 'v';       
        cArray[3] = 'a';       
        cArray[4] = '!';
        //cArray[5] = '';  char타입은 배열이 비어있으면 오류발생한다
        /*  
        iArray dArray cArray 배열 이름으로 출력하면 배열과 관련된 정보를 표기 
            그 정보에 참조값이 포함됩니다 
            *** 변수값이 다르면 식별값이 다르다 
            */

        System.out.print("\n1.  "); //.  [I@372f7a8d
        System.out.println(iArray);
        System.out.print("\n2.  ");
        System.out.println(dArray);
        System.out.print("\n3.  "); //.  [I@372f7a8d        변수값이 다르면 식별값이 다르다 -> 왜 값이 같아? : 주소값 넣어서 
        System.out.println(cArray);        

        int[] temp;     //크기 없는데 
        temp = iArray;  //iArray 의 주소값을 temp변수에 저장한거야 
        System.out.print("\n4.  ");
        System.out.println(temp);

        System.out.println("\n5. 참조값을 전달받은 temp 배열확인");
        temp[3]=999;
        System.out.println("temp[3]=" + temp[3]);   //999
        System.out.println("temp배열의 값" + Arrays.toString(temp));
        System.out.println("\n6. 어라? iArray도 똑같네~");
        System.out.println("iArray[3]=" + temp[3]); //999
        System.out.println("iArray배열의 값" + Arrays.toString(iArray));

        //다른 인덱스 값도 바꿔보세요 
        iArray[1]=1234;
        System.out.println("\n7. temp와 iArray는 하나의 배열을 가리킵니다");
        System.out.println("temp배열의 값" + Arrays.toString(temp));    /*값[1, 1234, 3, 999, 5]
                                                                            iArray를 바꿨는데 temp도 바뀜*/


        /*
        int[] temp;      
        temp = iArray;   : 참조형
        */                                                                   
        int age=23;
        
        int itemp;
        itemp = age;    //값만 저장 : 기본형



    }
    
}
