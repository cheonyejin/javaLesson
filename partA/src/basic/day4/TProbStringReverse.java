package basic.day4;

public class TProbStringReverse {
    public static void main(String[] args) {
        String message = "Hello World";  //길이는 11 인덱스는 0~10
         //문자열의 길이만큼 배열의 크기를 정합니다.
         char[] messageArray = new char[message.length()];

        int cidx = message.length()-1; //10
        for (int i = 0; i < message.length(); i++){
            char temp = message.charAt(i);
            messageArray[cidx]=temp;
            cidx--;
        }


    }
    
}
