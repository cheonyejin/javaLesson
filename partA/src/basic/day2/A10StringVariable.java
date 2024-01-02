package basic.day2;

public class A10StringVariable {
    
    public static void main(String[] args) {
        /*
         * string은 문자열: 문자의 집합 ''
         * char imo = '😊' 이런 이모지는 4바이트이니때문에 문자로 저장되지 않는다
         * String = "😊" 이렇게 이모지는 문자열로 처리해야됨
         * 따라서 String 문자열 리터럴은 ""을 사용한다 
         *         char                 ''을 사용한다  
         */

        String imo = "😊";
        System.out.println();

        String message = "안녕해들아~";
        System.out.println(message);
        System.out.println(message + " 의길이 " + message.length());


        message = "어서와 자바세상에";
        System.out.println(message + " 의길이 " + message.length());

        String Test = "This is Test Tect.";
        //String으로 선언된 변수는 갹체이다 
        //그래서 여러가지 기능등으 제공해준다
        // 자바 Strnig의 중요메서드 10가지 테스트해보기 

        System.out.println(Test.charAt(0)); //문자열
        System.out.println(Test.equals(message)); //문자열 비교 
        System.out.println(Test.indexOf("is")); //문자열 찾기 
        System.out.println(Test.length());// 문자열 길이 
        System.out.println(Test.replace("this", "It")); //문자열대치 
        System.out.println(Test.substring(0)); //문자열 잘라내기
        System.out.println(Test.trim()); //공백제거







    }
}
