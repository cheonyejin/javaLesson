package io.day14;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ThreadTest { //D07소스 활용

    public static void main(String[] args) {
        
        //실행 시간이 오래 걸릴 경우 실행 중이라는 표시를 사용자에게 보여줍니다.
        //              ㄴ1초마다 . 출력하기 -> 새로운 스레드로 만들어보기 
        // 1) Thread클래스 상속받기 
        // 2) Runnable 인터페이스 구현하기


        // 1. 스레드가 할 일을 인터페이스를 활용하여 정의하기-> 익명 클래스 
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //스레드가 할일을 여기에 코딩하세요
                boolean run= true;
                while (run) {
                    System.out.println(".");
                    try {
                        Thread.sleep(500); //1000ms=1초
                    } catch (InterruptedException e) {
                        //InterruptedException : 방해하다.
                        run=false;

                    }
                }
            }
        };
        // 2. 스레드 생성하기 / 할일은 인자로 넣어주기 
        Thread thread = new Thread(runnable);
        // 3. 스레드 실행하기 
        thread.start();

        long start = System.nanoTime();    //System에서 시간측정 메소드: 방법1. 나노세건트 10억분의 1 , 방법2. ms 1000분의 1 
        //처리해야할 메소드
        copyByByte();
        //copyByBuffer();
        //copyByByteArray();
        long end = System.nanoTime();
        System.out.println(String.format("소요시간 : %,d ms",(end-start))); //소요시간 : 20,977,300 ms

        // 4. 스레드 종료를 위해 인터럽트 발생하기 
        //thread.stop(); //stop()은 안쓰는 메소드이다 
        thread.interrupt();
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
        System.out.println(String.format("\n복사한 파일 크기 : %,d 바이트",count)); //2.47MB (2,595,514 바이트)
    }
    //복사한 파일 크기 : 2,595,514 바이트
    //소요시간 : 3,862,650,300 ns  




}
