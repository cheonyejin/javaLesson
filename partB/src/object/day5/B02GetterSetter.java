package object.day5;

public class B02GetterSetter {

        public static void main(String[] args) {
            MyClass2 momo = new MyClass2();
            System.out.println("myclass2 field1 값 변경 전 "+momo.getField1());
            momo.setField1("나는 모모");        //리터럴 됨
            System.out.println("myclass2 field1 값 변경 후 "+momo.getField1());

            String message ="WELCOME~!!";
            momo.setField1(message);               //변수도 됨
            System.out.println("myclass2 field1 값 변경 후 "+momo.getField1());



            System.out.println("myclass2 field2 값 변경 전 "+momo.getField2());
            momo.setField2(999);                //정수도 됨
            System.out.println("myclass2 field2 값 변경 후 "+momo.getField2());
            System.out.println("\n지금까지 momo 객체값들은 ");
            momo.printData();       //모든 인스턴스 필드값을 출력해주는 메소드
            int test = 1212;
            momo.setField2(test);                  //변수도 됨
            System.out.println("\nmyclass2 field2 값 변경 후 "+momo.getField2());


            System.out.println("~~~~~~~~~~~~~field3은 double배열 타입입니다.~~~~~~~~~~~~~~");
            double[] dArray = momo.getField3();             //방법1, 배열 만들기 
            System.out.println("field3 : " +  dArray);      
            System.out.println("field3 : " +  momo.getField3());    //2. 직접주기
            
            double[] tempArray = {1.2,3.44,67.12};
            momo.setField3(tempArray);
            System.out.println("변경된field 3을 확인합니다 ");
            momo.printData();       //모든 인스턴스 필드값을 출력해주는 메소드
            momo.setField3(new double[5]);  //크기는 5지만 내용이 없다-> [0.0, 0.0, 0.0, 0.0, 0.0]

            System.out.println("변경된 field 3 확인합니다");
            momo.printData();

            //setField3을 변수로 전달했을때 
            tempArray[2]=3.1415;    //주소 제3자의 의해서 바뀌기 
            System.out.println(tempArray);
            momo.printData();
        







        }

    
}
