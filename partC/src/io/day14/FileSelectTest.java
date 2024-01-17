package io.day14;

import javax.swing.JFrame;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class FileSelectTest {
    public static void main(String[] args) {
        
        //GUI :grapic user interface
        // java.awt와 java.swing에서 제공합니다

        JFrame jf = new JFrame();
        //jf.setSize(200,200);
        jf.setVisible(false);

        FileDialog fd = new FileDialog(jf,"파일선택",FileDialog.LOAD);
        fd.setVisible(true);
        // System.out.println("선택한 폴더 : " + fd.getDirectory());       
        // System.out.println("선택한 파일 : " + fd.getFile());
        // System.out.println(fd.getDirectory().replace("\\", "\\\\") + fd.getFile());  //폴더와 파일을 합칠때는 \\ 을 붙여야됌

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
