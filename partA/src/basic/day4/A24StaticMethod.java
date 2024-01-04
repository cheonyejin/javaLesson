package basic.day4;

public class A24StaticMethod {
    //프로그램을 실행시키는 main이 static이므로 여기서 같이 사용할수있는 다른 static메소드 연습을 해봅시다
    // 메소드를 만드는 목적은 특정처리 기능을 main에서 따로 분리하기 (구조화)
    // 한번 만들어진 메소드는 여러번 실행가능 (재사용)
    // 메소드는 클래스의 구성요소 

    public static void main(String[] args) {
        argumentTest();                  //메소드 호출
        argumentTest(999);             //이름(agumentTest)과 형식(999)이 맞는 메소드를 호출한다
        argumentTest(999, 333);      //실 매게변수 , 매게변수 갯수 제한이 없음
        int a=100;
        int b=522;
        argumentTest(a, b);      //실 매게변수 , 매게변수 갯수 제한이 없음

        //4.
        int result = resurltIntTest();
        System.out.println("result = " + result);
        System.out.println("resultIntTest리턴값= "+ resurltIntTest());
        //5.
        boolean resultboolean = resurltbooleanTest();
        System.out.println("resultboolean = " + resultboolean);
        System.out.println("resurltbooleanTest리턴값= "+ resurltbooleanTest());
        //6.
        String resultString = resurlStringTest();
        System.out.println("resultString = " + resultString);
        System.out.println("resurlStringTest리턴값= "+ resurlStringTest());
        //7.
        char resultChar = resurltCharTest();
        System.out.println("resultChar = " + resultChar);
        System.out.println("resurltCharTest리턴값= "+ resurltCharTest());
        //8.
        System.out.println(add(1, 2, 3));
        System.out.println(add(4, 5, 6));
        System.out.println(add(7, 8, 9));
        System.out.println(add(10, 11, 12));
        //9.
        System.out.println(add(1.1, 1.2, 1.3));
        System.out.println(add(1.2, 1.3, 1.4));
        System.out.println(add(1.3, 1.4, 1.5));
        System.out.println(add(1.4, 1.5, 1.6));


    }  
        //1.인자가 없는 메소드
    public static void argumentTest(){
        System.out.println("인지가 없는 메소드입니다");
    }
        //2.인자가 1개인 메소드
    public static void argumentTest(int i){  //인자로 사용된 변수는 메소드 안에서만 사용이 가능합니다 -> 지역변수 
        System.out.println("인자가 1개 정수 " + i +"입니다");
    }    
        //3.인자가 2개인 메소드
    public static void argumentTest(int i , int j){
        System.out.println("인자가 2개 정수 i= " +i + " j= "+ j + "입니다");

    }
        //4.리턴값이 정수인메소드
    public static int resurltIntTest(){
        return 999;

    }   
        //5.리턴값이 boolean인메소드
    public static boolean resurltbooleanTest(){
        return false;
    }    
        //6.리턴값이 String인메소드
    public static String resurlStringTest(){
        return "Hello";
    }
        //7.리턴값이 Char인메소드
    public static char resurltCharTest(){
        return 'A';
    }

    //8. 인자와 리컨값을 갖는 메소드 -int
    public static int add (int a, int b, int c){
        return a+b+c;
    }
    //9. 인자와 리턴값을 갖는 메소드 -double
    public static double add (double a, double b, double c){
        return a+b+c;
    }   
    
    
}
