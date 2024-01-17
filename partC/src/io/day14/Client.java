package io.day14;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;

/* 
socket : 클라이언트와 서버 각각 실행하는 메소드가 다르다 . 서버와 클라이언트 연결과정이 다르기 때문이다. (그림 참고 )
*/
public class Client {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            System.out.println("[클라이언트 ]프로그램 입니다.");
            socket= new Socket();
            //시간 중지 타임 설정 
            Thread.sleep(3000);     //(3000ms)가
            //서버에서 설정한 bind정보와 같은 객체를 만듭니다 
            socket.connect(new InetSocketAddress("192.168.30.19",5050));
            System.out.println("연결 성공하였습니다.");




            //서버가 보낸 메세지 받기 -InputStream
            InputStream is = socket.getInputStream();           //출력 스트림
            DataInputStream dis = new DataInputStream(is);      //보조 스트림
            String message = dis.readUTF();                     //readUTF() : 읽는 메소드
            System.out.println("message : "+message);




            //서버에게 인사말 보내기 -OutputStream , writeUTF
            OutputStream os = socket.getOutputStream();         //출력 스트림
            DataOutputStream dos = new DataOutputStream(os);    //보조 스트림
            System.out.println("서버에게 보낼 메세지를 입력하세여");
            message = System.console().readLine();  
            dos.writeUTF("\tFrom클라이언트 "+message);           //writeUTF : 쓰는 메소드 




            //서버에게 이미지 파일 보내기(업로드)
            //String filePath = "C:\\Users\\Administrator\\Downloads\\babycat.png";
            Map<String, String> map = showDialog();      //map을 이용해서 
            String filePath = map.get("folder") + map.get("filename");
            //파일명을 서버에게 보내서 서버도 원래 파일명으로 다운도르 하도록 하기 
            dos.writeUTF(map.get("filename"));
            //파일입력을 받아 소켓으로 출력하기 
            FileInputStream fis = new FileInputStream(filePath);
            BufferedInputStream bis = new BufferedInputStream(fis);
            int b;
            while ((b=bis.read())  != -1) {     //파일에서 읽어오기
                dos.write(b);                   //소켓출력
                
            }System.out.println("파일 업로드 완료");








        
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally{
            try { socket.close();
              
            } catch (IOException e) {
               
            }
        }
    }//main



    public static Map<String,String>  showDialog(){
        Frame jf = new JFrame();
        //jf.setSize(200,200);
        jf.setVisible(false);

        FileDialog fd = new FileDialog(jf,"파일선택",FileDialog.LOAD);
        fd.setVisible(true);

        Map<String,String> map = new HashMap<>();                   //map에 담으면 여러개 많이 만들수있어 
        map.put("folder", fd.getDirectory().replace("\\", "\\\\"));
        map.put("filename", fd.getFile());
        return map;
    }
    
}
