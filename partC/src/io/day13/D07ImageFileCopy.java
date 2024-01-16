package io.day13;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class D07ImageFileCopy {

    public static void main(String[] args) {
        
        long start = System.nanoTime();    //System에서 시간측정 메소드: 방법1. 나노세건트 10억분의 1 , 방법2. ms 1000분의 1 
        //처리해야할 메소드
        // copyByByte();
        copyByBuffer();
        // copyByByteArray();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ms",(end-start))); //소요시간 : 20,977,300 ms
    }
    // 순수하게 1바이트씩 입출력 파일입력 => 파일출력(파일복사)
    public static void copyByByte() {
        int b; 
        int count=0;
        FileInputStream fis = null;
        FileOutputStream fos =null;
        try{
            fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg"); //이미지 경로까지 포함
            fos = new FileOutputStream("계곡복사.jpg"); //복사한 이미지의 이름을 지정
            while((b=fis.read()) != -1){      
                //1바이트 씩 복사하기(파일fis에서 파일fos 로)
                fos.write(b);
                count++;
            }
        }catch(IOException e) {
            System.out.println("파일 입출력 예외 : " + e.getMessage());
        }finally {
            try{ fis.close(); fos.close();}
            catch(IOException e) {}
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count)); //2.47MB (2,595,514 바이트)
    }
    //복사한 파일 크기 : 2,595,514 바이트
    //소요시간 : 3,862,650,300 ns  


    public static void copyByByteArray() {
        int b; int count=0;
        byte[] buffer = new byte[1024];     //바이트 배열을 이용해서 1024바이트씩 입출력
                                            //          -> 버퍼에서 사용.버퍼입출력스트림

        //try with resources - try의 () 안에 close 해야할 자원(리소스,파일입출력스트림)을 선언하면
        //      - finally 없이 close 자동으로 합니다.이 때 자원은 AutoCloseable 인터페이스 구현체이어야 합니다.
        try
        (FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
        FileOutputStream fos = new FileOutputStream("sea.png");
        ){
            while((b=fis.read(buffer,0,buffer.length)) != -1){      
                //read(배열이름,시작위치,최대길이) 리턴값 b는 실제 읽어온 바이트 수
                //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할 수 있음. 
                fos.write(buffer,0,b);      //write(배열이름,시작인덱스,출력길이)
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    // 복사한 파일 크기 : 2,595,514 바이트
    // 소요시간 : 18,517,000 ns


    public static void copyByBuffer() {
        int b; int count=0;
        byte[] buffer = new byte[1024];     //바이트 배열을 이용해서 1024바이트씩 입출력
                                            //          -> 버퍼에서 사용.버퍼입출력스트림

        //try with resources - try의 () 안에 close 해야할 자원(리소스,파일입출력스트림)을 선언하면
        //      - finally 없이 close 자동으로 합니다.이 때 자원은 AutoCloseable 인터페이스 구현체이어야 합니다.
        try
        (FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Downloads\\계곡.jpg");
        FileOutputStream fos = new FileOutputStream("sea.png");
        BufferedInputStream bis = new BufferedInputStream(fis);         //보조 버퍼입력스트림
        BufferedOutputStream bos = new BufferedOutputStream(fos);       //보조 버퍼출력스트림
        ){
            while((b=fis.read(buffer,0,buffer.length)) != -1){      
                //read(배열이름,시작위치,최대길이) 리턴값 b는 실제 읽어온 바이트 수
                //길이 1024바이트가 안될수도 있으므로 실제 읽어온 바이트 수를 알아야 처리할 수 있음. 
                fos.write(buffer,0,b);      //write(배열이름,시작인덱스,출력길이)
                count+=b;
            }
        }catch(IOException e) {
        System.out.println("파일 입출력 예외 : " + e.getMessage());
        }
        System.out.println(String.format("복사한 파일 크기 : %,d 바이트",count));
    }
    // 복사한 파일 크기 : 2,595,514 바이트
    // 소요시간 : 18,517,000 ns




}
