package basic.day5;

public class A30HashCode {
    public static void main(String[] args) {
        
        int[] iArray = new int[10];
        String message = "Hello~ world~~";

        /*Hashcode는 참조값(식별값)을 만들기 위해 해쉬함수로 생성된 결과입니다.
        따라서 , hascode=참조값 */
        System.out.println(iArray); //배열의 식별값을 보여줍니다(16진수)                          //[I@372f7a8d
        System.out.println(iArray.hashCode()); //해쉬코드를 가져온다 (10진수)                    //7925858445    초기 해쉬코드
        System.out.println(Integer.toHexString(iArray.hashCode())); //10진수를 16진수로 변환    //372f7a8d

        iArray[3]=99;
        System.out.println(iArray.hashCode());                                                //798154996      배열 요소값을 변경한 후 해쉬코드 
        //바뀌지 않았다 
        // 따라서, 배열값이 변경되어도 메모리의 위치는 동일하다

        System.out.println("\nSting 배열 message의 해시코드 값: " + message.hashCode());        //-334213954
        message = message + " ~ good~";
        System.out.println("\n message 를 변경한 후 해시코드 값: " +  message.hashCode());      //902045661
        //바뀌었다 
        // 따라서, 문자열은 내용이 변경되면 메모리의 위치는 바뀐다

        /*
         * 객체란, 여러 종류의 데이터가 모여있는 데이터 덩어리 
         * 기본형은 데이터의 최소단위 
         * 객체는 참조형을 사용한다 (= 변수가 주소값을 저장한다 )
         * 
         * 객체를 메모리에 저장한 경우 
         *  1. 초기에 저장한 데이터를 바꿀수있다(배열)  ->가변객체
         *  2. 초기에 저장한 데이터를 바꿀수없다(문자열) ->불변객체
         */









    }   
    
}
