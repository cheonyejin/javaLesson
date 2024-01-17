package io.day12;

// 표준 입출력 키보드 테스트
// 키보드 입력 : new Scanner(System.in) 또는 System.console().readLine()
public class D03StandardIOTest {
    public static void main(String[] args) {
        int b, count = 0;
        System.out.print("입력하세요 ㅇㅇㅇㅇㅇㅇㅇ ");
        try {
            while ((b=System.in.read()) != -1) { // -1(입력 끝)은 ctrl+z
                // b = System.in.read(); // 원초적 입력
                System.out.write(b);
                count++;
            }

            System.out.println("총 입력한 바이트 수 : " + count);
        } catch (Exception e) {
            System.out.println("예외 : " + e.getMessage());
        }
    }
}
