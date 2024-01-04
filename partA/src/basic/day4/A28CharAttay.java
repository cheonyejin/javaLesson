package basic.day4;
//문자열은 문자의 집합., 따라서 문자열 구성하는 문자 하나씩 가져와 배열에 저장해봅시다 
public class A28CharAttay {
    public static void main(String[] args) {
        String message = "Hello~ World~ 자바는 맛있다.";

        //문자열의 길이만큼 배열의 크기를 정합니다.
        char[] messageArray = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            System.out.println(temp);  
            messageArray[i] = temp;
        }

        //char 배열의 특징, 배열이름으로 프린트하면? 문자열처럼 출력됩니다 
        System.out.println(messageArray);  //char은 잘 나온다 //A27은 정수 배열이므로 안되는데 이건 char배열이여서 됨

        /* 
        고대 암호 : '모모'가 '나연'이 한테 비밀 메세지를 보냅니다 .
        암호문을 만듭니다 두 사람이; 알고있는 비밀키 값을 하나 정합니다 key=7
        암호문은??
        */
        int key =7;
        for(int i = 0; i < message.length(); i++){
            messageArray[i]+=key;
        }
        System.out.println("모모가 나연이에게 보낸 비밀 메세지 : ");
        System.out.println(messageArray); //Olssv?'^vysk?'잗받늛'맢잏닫5         라고 출력됨

        System.out.println("나연이는 받은 메세지를 읽으려고 암호문을 풀었다");
        for(int i = 0; i < message.length(); i++){
            messageArray[i]-=key;
        }
        System.out.println("비밀 메세지는 : ");
        System.out.println(messageArray);
    }
    
}
