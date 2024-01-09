package object.day6;

public class B05ConstructorTest {

    public static void main(String[] args) {
        
        MyClass4 my = new MyClass4();
        System.out.println("기본생성자 실행");
        System.out.println(" my field2 : " + my.getField2());

        System.out.println("인자 1개 커스텀 생성자 실행");
        MyClass4 my1 = new MyClass4(222);    
        System.out.println("my1 field2 : " + my1.getField2());

        MyClass4 my2 = new MyClass4("Hello");
        System.out.println(" my2 field1 : " + my2.getField2());

        System.out.println("인자 2개 커스텀 생성자 실행");
        MyClass4 my3 = new MyClass4("java",222);
        System.out.println(" my3 field1 : " + my3.getField1());
        System.out.println(" my3 field2 : " + my3.getField2());

        System.out.println("인자 3개 커스텀 생성자 실행");
        MyClass4 my4 = new MyClass4("java",222, new double[3]);
        System.out.println(" my4 field1 : " + my4.getField1());
        System.out.println(" my4 field2 : " + my4.getField2());
        System.out.println(" my4 field3 : " + my4.getField2());




        //기본 생성자와 setter가 없는 MyClass5 객체 생성해보기 
        MyClass5 my5 = new MyClass5("langyage", 1111, new double[3]);
        // MyClass5 my6 = new MyClass5();       -> 오류 :  기본 생성자가 없는 클래스 이므로 
                                                    //public MyClass5() {} 이거 MyClass5에 넣으면 오류 해결됨 
        System.out.println("MyClass5 실행해보기");
        System.out.println(" my5 field1 : " + my5.getField1());
        System.out.println(" my5 field2 : " + my5.getField2());
        System.out.println(" my5 field3 : " + my5.getField2());
       // MyClass5 my55 = new MyClass5("프로그램", 122, new double[]
        MyClass3 test = new MyClass3();
        test.setField1("파이썬");
        test.setField2(9999);
        test.setField3(new double[]{1.2,34.56,123.45});
        
        //기본 생성자는  set메소드로 직접 밗을 초기화 하는것이 조금 불편합니다 
        // 초기화를 위해서는 커스텀 생성자가 좋급니다 

        //결론 : MyClass3과 같이 생성자 메소드가 직접 정의된것이 없으면 기본생성자만 사용 가능합니다 
            // MtClass3은 기본생성자가 생략된 상태이다
        //그러나 , MyClass5와 같이 커스텀 생성자 메소드가 하나라도 정의되어 있으면 기본  생성자도 사용 못합니다 
        // 사용하고 싶으면 직접 정의해야한다 

        

    }
    
}
