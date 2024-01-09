package object.day5;

import java.util.Arrays;

//이거 getter setter 메소드

public class MyClass2 {
    /*main없는 클래스 - 단순 데이터 저장
    다른 클래스에서 호출하는 메소드를 정의하는 용도 */

    //인스턴스 필드 - private 선언해야됨 
    //private: 현재 클래스 이외는 사용 불가 
    private String field1;
    private int field2;
    private double[] field3; //배열이니까 참조값 저장하는 변수이다

    //private변수를 다른클래스에서 값을 읽고 또는 저장하기 -> getter(가져오는 읽는), setter
    //필드값을 가져오는 메소드 : getter
    public String getField1(){  //1. private String field1;

        return field1;    
    }
    public int getField2(){     //2. private int field2;
        return field2;
    }
    public double[] getField3(){    //3. private double[] field3;
        return field3;              // 배열의 참조값을 리턴한다 
    }


    //필드값을 변경하는 메소드 : setter
    public void setField1(String f1){   //1. private String field1;
        field1 = f1;        // 인스턴스 필드가 바뀌게끔 바꾼다
    }
    public void setField2(int f2){      //2. private int field2;
        field2 = f2;

    }
    public void setField3(double[] f3){ //3. private double[] field3; //tempArray가 갖고있는 2000
        //field3 = f3;    
        //참조값을 대입시키닙니다. 객체가 의도하지 않아도 쉽게 field3 배열값이 변경됩니다
        field3 = new double[f3.length]; //배열을 새로 생성하기 
        for (int i = 0 ; i <f3.length;i++)  //f3배열의 값을 복사하기 
            field3[i] = f3[i];
    
    }


    //모든 인스턴스 필드값을 출력해주는 메소드
    public void printData(){
        System.out.println("field = " + field1 + "field2=" + field2 + 
        "field3=" + field3+ Arrays.toString(field3));
    }
}
