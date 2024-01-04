package basic.day4;

public class ProbStringReverse {
    public static void main(String[] args) {
        String message = "Hello World";  //길이는 11 인덱스는 0~10
         //문자열의 길이만큼 배열의 크기를 정합니다.
         char[] messageArray = new char[message.length()];

        System.out.print("기존의 메세지 = ");
        System.out.println(message);

         //문자열의 문자를 역순으로 배열에 저장
        for (int i = 0; i < message.length(); i++) {
            messageArray[i] = message.charAt(message.length() - 1 - i);
        }
        System.out.print("역순으로메세지 =");
        System.out.println(messageArray);



    }
    
}
