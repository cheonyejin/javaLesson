package io.day12;

import java.io.FileOutputStream;
import java.io.IOException;

// 키보드 입력을 파일로 출력
public class D04KeyInputFileOut {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("note.txt"); // 인자로 파일명 전달
            int b, count = 0;
            while ((b=System.in.read()) != -1) {
                fos.write(b);
                count++;
            }

            System.out.println("총 입력 바이트 수 : " + count);
        } catch (Exception e) {
            System.out.println("메롱");
        } finally {
            // 입출력 자원 해제는 여기서 하세요. 예외 발생 상관없이 처리할 명령어
            fos.close();
        }
    }
}


// 바이트 기반 스트림은 문자 형식의 파일이 아닐때
// 문자기반 기반 스트림은 문자 단위 입출력.