package io.day13;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class D10FileWriter {
//이제부터는 입력 ~,~
    public static void main(String[] args) {
       
        //writeByBuffer(); //단어장2
        writeByPrintWriter(); //단어장3

    }



    
    public static void writeByBuffer(){
        String filePath = "단어장2.txt";
        int count=0;
      
        try( BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,true))){

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                bw.append("안녕하세요요요요요"+i+"\r\n"); //append:기존의 내용에 더 추가함 (줄바꿈 별도추가해야됨)
                                           //(new FileWriter(filePath,true)) 생성자에 true는 추가 / flase는 덮어쓰기
                //bw.write("안녕하십니까"); ->기존파일에 덮어쓰기
                count++;
            }
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }



    public static void writeByPrintWriter(){        
        String filePath = "단어장3.txt";
        int count=0;
        File file = new File(filePath);
        ///PrintWriter클래스 특징: 1.print,println메소드 사용 가능 
        //                       2. File객체를 인자로 합니다
        try( 
        
            //PrintWriter pw = new PrintWriter(new FileWriter(filePath,true))){ //방법1. append할때 
            PrintWriter pw = new PrintWriter(new FileWriter(filePath,Charset.forName("UTF-8")))){   //방법2. 

            // 파일의 끝까지 반복
            for(int i=0;i<10;i++) {
                pw.append("할로~"+i+"\r\n");
                //pw.print("안녕하세요"+i+"\r\n");       
                count++;
            }
            
    } catch (Exception e) { }

        System.out.println("저장한 라인수 : "+count);
    }
}
