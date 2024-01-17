package io.day12;

import java.io.FileInputStream;
import java.io.IOException;

// 파일 입력 => 콘솔장치(화면) 출력
public class D05FileInputSysout {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("테스트.md");
            int b, count = 0;
            // 바이트 기반의 스트림 read 메소드는 데이터를 1바이트씩 읽어옵니다.
            while ((b=fis.read()) != -1) { // 파일의 끝을 만나면 -1
                System.out.write(b); // 윈도우 터미널 인코딩 방식 : MS949 (ANSI형식)
                count++;
            }

            System.out.println("\n총 출력 바이트 수 : " + count);
        } catch (IOException e) { // FileNotFoundException은 부모예외 IOException로 처리
            System.out.println("파일 입력 중 예외 발생 : " + e.getMessage());
        } finally {
            fis.close();
        }
    }
}
