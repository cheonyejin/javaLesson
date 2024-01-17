package io.day12;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// 파일 입력스트림으로 이미지 파일 읽어옵니다.
// ==> 파일 출력스트림으로 파일 내용을 출력합니다. (파일 복사)
public class D06FileCopyTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\images.jfif");
            fos = new FileOutputStream("MintChoco.jpg");
            int b, count = 0;

            while ((b=fis.read()) != -1) {
                fos.write(b);
                count++;
            }

            System.out.println("복사한 파일의 총 바이트 수 : " + count);
        } catch (IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        } finally {
            fis.close();
            fos.close();
        }
    }
}
