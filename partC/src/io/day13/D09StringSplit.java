package io.day13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D09StringSplit {

    private static String filePath = "score.txt";  //전역변수: 모든 메소드에서 사용할수있습니다(static에서만)

    public static void main(String[] args) {
        //split_test2();
        List<Score> list = makeList();
        System.out.println(makeList()); // 리턴받은 list내용을 출력할거다
        //위와 같다 System.out.println(list.toString()); 

        for (int i = 0; i < list.size(); i++) {
            System.out.println("i="+ i+"scoure object= " +list.get(i));
        }
        for(Score temp : list)
        System.out.println(temp);   //list.get(i)를 반복자로 실행해서 temp에 저장
        
    }

    public static Score makeScore(String line){
        String[] temp = line.split(",");     //객체 만들기 
        Score a = new Score(temp[0].trim(),               //값 넣기 
                        Integer.parseInt(temp[1].trim()) , //trim(): 공백 제거 
                        Integer.parseInt(temp[2].trim()), 
                        Integer.parseInt(temp[3].trim()));
        return a;
    }

    //1.score.txt에서 모든 데이터를 읽어오고 
    //2.score객체로 변환하여 
    //3.리스트에 담고 
    //4.리턴하기 
    public static List<Score> makeList(){
        List<Score> list = new ArrayList<>();        //3.리스트에 담고 
        try ( 
            BufferedReader br = new BufferedReader(new FileReader(filePath))){  //전역변수로 만든 filePath
                String line;
                while ((line = br.readLine()) != null) {        //n번째 줄 읽고    
                    Score stu = makeScore(line);   
                    list.add(stu);                  //3.리스트에 담고 
                }
           
        } catch (Exception e) {
           System.out.println("파일 입력 오류 : " + e.getMessage());
        }
        return list;    //4.리턴하기 
    }


    //BuffetReader클래스는 파일에서 1줄씩 읽어올수있다 
    //1줄읽고 score객체 만들기 -> 4개 만들어짐 (변수명 모두 stu 하나로 참조하고 출력하기)
    public static void split_test2(){
        
        int count = 0; //읽은 라인수
        try ( 
            BufferedReader br = new BufferedReader(new FileReader(filePath))){  //전역변수로 만든 filePath
                String line;
                while ((line = br.readLine()) != null) {        //n번째 줄 읽고    
                    // String[] temp = line.split(",");    //객체 만들기 
                    // Score stu = new Score(temp[0],              //값 넣기 
                    //     Integer.parseInt(temp[1]) , 
                    //     Integer.parseInt(temp[2]), 
                    //     Integer.parseInt(temp[3]));
                    Score stu = makeScore(line);           // makeScore()위에 만들었음
                    System.out.println(String.format("count = %d, score object = %s",count,stu));
                    count++;
                }
           
        } catch (Exception e) {
           System.out.println("파일 입력 오류 : " + e.getMessage());
        }
   
}



    public static void split_test1() {
        String stu = "김모모,67,77,88";
        //split() : 지정된 구분자를 이용해서 문자열을 분리하고 배열에 저장해서 리턴한다
        String[] temp = stu.split(","); //  , 을 구분자로 지정하기
        System.out.println("1. split 실행한 결과 문자열 배열은 ? ");
        System.out.println(Arrays.toString(temp));  //[김모모, 67, 77, 88]
        for(String t : temp)
            System.out.println("배열 요소 = " + t);

        System.out.println("2. 분리된 결과로 Score 객체를 만들면?");
        //temp[0]은 이름, temp[1]~temp[3]까지는 점수(문자열)  ->>> 정수로 변환해야된다: Integer.parseint
        Score score = new Score(temp[0],
                            Integer.parseInt(temp[1]) , 
                            Integer.parseInt(temp[2]), 
                            Integer.parseInt(temp[3]));
        System.out.println("score 출력 2 : "+score.datas());
         System.out.println("score 출력 1 : "+score);    //toString은 생략
    }
    
    
}
