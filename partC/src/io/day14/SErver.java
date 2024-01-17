package io.day14;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/* 
socket : 클라이언트와 서버 각각 실행하는 메소드가 다르다 . 서버와 클라이언트 연결과정이 다르기 때문이다. (그림 참고 )
프로그램 실행은 서버가 먼저 실행하기 
1.bind: 서버의 ip,port 설정
2.connect :
3.accept : 
*/
public class SErver {
    public static void main(String[] args) {
        ServerSocket server = null; 
        Socket socket = null;         
        BufferedOutputStream bos = null;
        OutputStream os = null; DataOutputStream dos = null;
        InputStream is = null; DataInputStream dis = null;
        try {

            // 나 21 대환 19 쌤 254
            //
            //    
            //

            //서버 설정을 위한 소켓 생성 `
            server= new ServerSocket();
            //서버 연결 정보 ip와 port 설정
            server.bind(new InetSocketAddress("192.168.30.19", 5050));
            System.out.println("[서버프로그램 시작] :  연결 요청을 기다리는 중입니다.");
            //클라이언트 연결 요청(connect)에 의한 수락            
            socket = server.accept();                               //입출력스트림을 만들 소켓 생성
            System.out.println("연결을 수락합니다.");             //accept 정상 완료되면 싱행.


            //클라이언트에게 데이터 보내기 : 출력 스트림 필요 
            //클라이언트와 서버가 연결된 소켓으로 출력 스트림 만들기
            os = socket.getOutputStream();
            //정수, 실스, 문자열 보내는 스트림
            dos = new DataOutputStream(os); //보조 스트림
            dos.writeUTF("\t From서버>>> 환영합니다 ");     //연결된 클라이언트에게 보낼 메세지 쓰기 

           
        
            //클라이언트가 보낸 인사말 받기
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            System.out.println(dis.readUTF());

             //1)파일명은 "d:\\다운로드.jpg"        다운로드 위치는 d드라이브
             //2)클라이언트가 보내준 파일명으로 저장  다운로드 위치는 d드라이브\
             String filename = dis.readUTF();
             System.out.println("\t클라이언트 업로드 파일명 : "+filename);
             bos = new BufferedOutputStream(new FileOutputStream("D:\\" + filename));
             int b; int count=0;
             while ((b=dis.read())!=-1) {
                 bos.write(b);       //버퍼스트림 이용한 바이트 단위 출력
                 count++;
             }
             System.out.println("파일 받기 완료 !! 총 바이트 :" + count);



        } catch (IOException e) {
            e.printStackTrace();    //예외 발생했을때 코드 수정하려면 필요하다 
        }finally{       //자원해제 , close()
            try { 
                server.close();
                socket.close();
                bos.close();
                dis.close();
                is.close();
                os.close();

            } catch (IOException e) {
                
            }
        }
    }
}
 