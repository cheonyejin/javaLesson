package basic.day3;

public class HomeCharType {

    public static void main(String[] args) {

        /* [과제-2024/0103 22시까지 제출] 문자열을 구성하는 문자의 종류 분석하기 ::
        1) message = "Hello* Java Hi* Linux~~~";
        2) 1)번의 문자열을 구성하는 문자 하나하나가 '대문자 '소문자 '숫자 '기호' 중 어떤 종류의 문자인지 검사합니다.
        3) 2)번의 검사를 통해서 문자열을 구성하는 문자의 종류와 개수를 구하여 출력합니다.
        변수명 :
        대문자의 갯수 upperCount
        소문자의 갯수 lowerCount, 숫자의 갯수 numberCount, 기호의 갯수 symbolCount
        HomeCharType.java
        출력 예시 :
        -----
        문자열 : Hello* Java Hi* Linux~~~ 문자 종류 : 대문자 4개, 소문자 12개, 숫자 0개, 기호 8개 */

        int upperCount = 0;
        int lowerCount = 0;
        int numberCount = 0;
        int symbolCount = 0;

        String message = "Hello* Java Hi* Linux~~~" ;
        
        for (char i : message.toCharArray()) {      //char[] chars = string.toCharArray();

            if (Character.isUpperCase(i)) {         //string을 char 배열로 변환하는 것
                upperCount++;

            } else if (Character.isLowerCase(i)) {  //isUpperCase() / isLowerCase() : 대문자/소문자인지를 확인
                lowerCount++;    
                                   //toUpperCase() / toLowerCase() : 대문자/소문자로 변환
            } else if (Character.isDigit(i)) {      
                numberCount++;                    
            /*   isDigit() 숫자인지 확인하는 메소드
            System.out.println(Character.isDigit('7'));  // true
            System.out.println(Character.isDigit('a'));  // false */

            } else {
                symbolCount++; 
            }
        }
        System.out.println("문자열 : " + message);
        System.out.println("문자 종류 : 대문자 " + upperCount + "개, 소문자 " + lowerCount + "개, 숫자 " + numberCount + "개, 기호 " + symbolCount + "개");
        // 기타 //isAlphabetic() : 알파벳인지 확인
    }
    
}
