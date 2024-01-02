package basic.day3;

public class A17ForWhileExam {
    public static void main(String[] args) {
        // 반복문 for가 활용되는 예시

        String message = "Hello, World~ Hoi";

        System.out.println("1.문자열 길이 만큼 문자 1개를 추출하는 반복문 실행하기");
        for (int i = 0; i < message.length(); i++) {
            // i =0 초기화; i<문자열길이 조건식; 반복할때 마다 i++ (주의 i는 for문안에서만 사용함)
            char temp = message.charAt(i);
            //charAt()는 문자열에서 특정 인덱스에 위치하는 유니코드 단일문자를 반환합니다.
            System.out.println("i = " + i + ", 문자 = " + temp);
        } // for

        // 위의 for문을 while문으로 바꿔서 출력
        int k = 0;
        while (k < message.length()) {
            char temp = message.charAt(k);
            System.out.println("k = " + k + ", 문자 = " + temp);
            k++;
        }

        System.out.println("\n문자열 길이만큼 반복문 실행하면서 if문 조건문으로 문자열 검사하기");
        System.out.println("\t문자열에서 알파벳 o의 개수를 구하기");
        int count = 0;

        for (int i = 0; i < message.length(); i++) {
            char temp = message.charAt(i);
            if (temp == 'o') {
                count++;
            }
        }

        System.out.printf("문자 o의 개수는 = %d개이다", count);
        //System.out.println(String.format("%d", message));

    }// main
}// class
